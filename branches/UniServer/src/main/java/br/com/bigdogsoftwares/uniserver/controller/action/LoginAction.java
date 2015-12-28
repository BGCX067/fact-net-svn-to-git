/**
 * 
 */
package br.com.bigdogsoftwares.uniserver.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import br.com.bigdogsoftwares.uniserver.controller.form.LoginForm;
import br.com.bigdogsoftwares.uniserver.model.dao.CadastroDAO;
import br.com.bigdogsoftwares.uniserver.model.entidade.mensagem.Mensagem;
import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Pessoa;

/**
 * @author jborba
 * 
 */
public class LoginAction extends DispatchAction {

	public LoginAction() {
	}

	public ActionForward efetuarLogin(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		Pessoa pessoaDaBase = new CadastroDAO().efetuarLogin(loginForm.getMatricula(), loginForm.getSenha());
		boolean isPessoaExisting = pessoaDaBase == null ? false : true;
		if (isPessoaExisting) {
			if (loginForm.getSenha().equals(pessoaDaBase.getSenha())) {
				response.setContentType("application/json");
				response.getWriter().write(new Mensagem("Login confirmado", false).toJSON());
				return null;
			} else {
				response.setContentType("application/json");
				response.getWriter().write(new Mensagem("Login não confirmado", true).toJSON());
				return null;
			}
		} else {
			response.setContentType("application/json");
			response.getWriter().write(new Mensagem("Usuário não cadastrado", true).toJSON());
			return null;
		}
	}

	public ActionForward realizarCadastro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LoginForm loginForm = (LoginForm) form;
		Pessoa pessoaDaBase = new CadastroDAO().verificarLogin(loginForm.getMatricula());
		boolean isPessoaExisting = pessoaDaBase == null ? false : true;
		if (isPessoaExisting) {
			response.setContentType("application/json");
			response.getWriter().write(new Mensagem("Pessoa já registrada", true).toJSON());
			return null;
		} else {
			String matriculaStr = loginForm.getPessoa().getMatricula().toString();
			loginForm.getPessoa().setNome("Guest_" + matriculaStr.substring(matriculaStr.length() / 2));
			new CadastroDAO().salvar(loginForm.getPessoa());
			response.setContentType("application/json");
			response.getWriter().write(new Mensagem("Cadastro realizado", false).toJSON());
			return null;
		}
	}

}