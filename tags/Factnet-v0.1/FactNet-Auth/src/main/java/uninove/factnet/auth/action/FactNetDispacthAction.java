package uninove.factnet.auth.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uninove.factnet.auth.services.AuthServices;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.exceptions.BusinessException;
import uninove.factnet.exceptions.InvalidLoginException;

public class FactNetDispacthAction extends DispatchAction{
	
	protected static Logger logger = Logger.getLogger(FactNetDispacthAction.class);
	
	private final ApplicationContext applicationContext = 
		new ClassPathXmlApplicationContext("factnet-bean-factory.xml");
	
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession(false);
		logger.debug("Nenhuma ação foi informada, enviando request para a Home");
		if(session != null){
			session.invalidate();
			session = null;
		}
		logger.info("Sessão invalidada");

		return mapping.findForward("comercial");
	}
	
	
	
	protected PessoaDTO obterUsuarioLogado(HttpServletRequest request, HttpServletResponse response){
		PessoaDTO pessoa = null;
		HttpSession session = request.getSession(false);
		if(session != null){
			pessoa = (PessoaDTO) session.getAttribute("PESSOA"); 
		}
		
		return pessoa;
	}
	
	protected PessoaDTO validarLogin(String login, String  senha, PessoaDTO pessoaTemp)throws InvalidLoginException{
		try{
			if(login == null || login.trim() == ""){
				throw new InvalidLoginException("Login vazio ou em branco");
			}else if(senha == null || senha.trim() == "") {
				throw new InvalidLoginException("Senha vazia ou em branco");
			}else{
				AuthServices services = (AuthServices)obterServicos("authServices");
				pessoaTemp.setEmailLogin(login);
				pessoaTemp.setSenha(senha);
				pessoaTemp = services.buscarLogin(pessoaTemp);
			}
		}catch (BusinessException e) {
			throw new InvalidLoginException(e.getMessage(), e);
		}catch (InvalidLoginException e) {
			throw e;
		}catch (Exception e) {
			throw new InvalidLoginException("Erro ao efetuar login tente novamente em instantes.");
		}
		return (pessoaTemp == null ? null : pessoaTemp) ;
	}
	
	public Object obterServicos(String nomeServico)throws BusinessException{
		Object servico = null;
		logger.info("Buscando o serviço: ["+nomeServico+"]");
		try{
			if(applicationContext.containsBean(nomeServico)){
				servico = applicationContext.getBean(nomeServico);
			}else{
				logger.error("O serviço informado não foi encontrado, nome do serviço : ["+nomeServico+"]");
				throw new BusinessException("Servico não encontrado");
			}
		}catch (Exception e) {
			logger.error("Ocorreu um erro ao obter Serviços via Spring", e);
		}
		logger.info("Serviço encontrado com sucesso.");
		return servico;
	}
	
	@SuppressWarnings("rawtypes")
	protected Logger getLogger(Class classe){
		return Logger.getLogger(classe);
	}

}
