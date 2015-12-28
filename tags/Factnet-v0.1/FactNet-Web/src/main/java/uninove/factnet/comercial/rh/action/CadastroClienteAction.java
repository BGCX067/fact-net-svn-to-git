/**
 * 
 */
package uninove.factnet.comercial.rh.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import uninove.factnet.auth.action.FactNetDispacthAction;
import uninove.factnet.comercial.rh.dtos.CadastroClienteDTO;
import uninove.factnet.comercial.rh.form.CadastroClienteForm;
import uninove.factnet.comercial.rh.services.CadastroClienteServices;
import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.EMeioInclusao;
import uninove.factnet.enums.ESexo;
import uninove.factnet.enums.ETipoPessoa;
import uninove.factnet.exceptions.InvalidLoginException;

/**
 * @author cjalmeida
 *
 */
public class CadastroClienteAction extends FactNetDispacthAction{
	
	Logger log = getLogger(this.getClass());
	
	public ActionForward iniciarCadastro(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "";
		PessoaDTO pessoa = super.obterUsuarioLogado(request, response);
		
		if(pessoa != null){
			forward = "existente";
		}else{
			forward = "iniciar";
		}
		return mapping.findForward(forward);
	}
	
	public ActionForward cadastrar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try{
				CadastroClienteForm cadastro = (CadastroClienteForm)form;
				if(validarCadastro(cadastro)){
					//Retornar Gson de Erro;
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					response.getWriter().write("Erro ao efetuar cadastro, as informações inseridas estão erradas");
					return null;
				}
				CadastroClienteServices cadastroServices = null;
				
					cadastroServices = (CadastroClienteServices) obterServicos("cadastroServices");
				
				CadastroClienteDTO cadastroDto = cadastroServices.cadastrarCliente(parseCadastroFormToDto(cadastro));
				if(cadastroDto != null && cadastroDto.getPessoa().getId() != null){
					String message = "Cadastro realizado com sucesso\n";
					message+="Login: "+cadastro.getEmail()+"\n";
					message+="Senha: "+cadastro.getSenha();
					message+="Obrigado pela preferencia, esperamos atende-lo sempre";
					response.getWriter().write(message);
				}else{
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					String message = "Cadastro não realizado. Tente novamente\n";
					response.getWriter().write(message);
				}
		}catch (InvalidLoginException e) {
			log.error("Erro ao efetuar cadastro.",e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Erro ao efetuar cadastro.",e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			response.getWriter().write("Erro ao efetuar cadastro, tente novamente em breve");
		}
		return null;
	}
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return super.unspecified(mapping, form, request, response);
	}
	
	private boolean validarCadastro(CadastroClienteForm form){
		boolean erro = false;
		if(form.getCep().trim() == "") erro = true;
		if(form.getCidade().trim() == "") erro = true;
		if(form.getDataNascimento() == null) erro = true;
		if(form.getEmail().trim()== "" || !form.getEmail().contains("@") || !form.getEmail().contains(".com")) erro=  true;
		if(form.getNome().trim() == "") erro = true;
		if (form.getNuCasa().intValue() == 0) erro = true;
		if(form.getPais().trim() == "") erro = true;
		if(form.getSenha().trim() == "") erro = true;
		if(form.getSexo() != 'F' && form.getSexo() != 'M') erro = true;
		if (form.getSobrenome().trim() == "") erro = true;
		
		
		return erro;
	}

	private CadastroClienteDTO parseCadastroFormToDto(CadastroClienteForm form) throws Exception{
		CadastroClienteDTO cadastro = new CadastroClienteDTO();
		PessoaDTO pessoa = new PessoaDTO();
		
		try{
			pessoa.setNome(form.getNome());
			pessoa.setSobrenome(form.getSobrenome());
			pessoa.setEmailLogin(form.getEmail());
			pessoa.setPermissoes(new PermissaoVO());
			pessoa.setSenha(form.getSenha());
			pessoa.setTipoPessoa(ETipoPessoa.CLIENTE);
			
			cadastro.setPessoa(pessoa);
			
			cadastro.setSexo(ESexo.parser(form.getSexo()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			cadastro.setDataNasc(format.parse(form.getDataNascimento()));
			cadastro.setMeioInclusao(EMeioInclusao.parser(form.getMeioInclusao()));
			cadastro.setTelefone(Long.parseLong(form.getNuTelefone().replace("(", "").replace(")", "").replace("-", "").replace(" ", "").trim()));
			cadastro.setPais(form.getPais());
			cadastro.setCidade(form.getCidade());
			cadastro.setCep(form.getCep());
			cadastro.setEndereco(form.getEndereco() +", "+form.getNuCasa());
			cadastro.setFlAtivo(true);
		}catch (Exception e) {
			e.printStackTrace();
			log.error("Erro ao fazer o parse de CadastroClienteForm para CadastroForm", e);
			throw e;
		}
		return cadastro;
	}
	
	
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PessoaDTO pessoa = null;
		try{
				pessoa = obterUsuarioLogado(request, response);
				if(pessoa == null){
					String login = request.getParameter("login");
					String senha = request.getParameter("senha");
					pessoa = new PessoaDTO();
					
					pessoa = validarLogin(login, senha, pessoa);
					//System.out.println(ToStringBuilder.reflectionToString(pessoa.getPermissoes()));
				}
		}catch (Exception e) {
			request.getSession().setAttribute("PESSOA", null);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}
		request.getSession().setAttribute("PESSOA", pessoa);
		return null;
	}
	
}
