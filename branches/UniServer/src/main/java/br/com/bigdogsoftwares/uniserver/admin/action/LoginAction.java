package br.com.bigdogsoftwares.uniserver.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.bigdogsoftwares.uniserver.admin.form.PessoaForm;
import br.com.bigdogsoftwares.uniserver.model.dao.admin.AdminstradorDAO;
import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Adminstrador;

public class LoginAction extends BaseAction{

	public ActionForward logar(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		PessoaForm pessoaForm = (PessoaForm)form;
		
		if(pessoaForm.getLogin() == null || pessoaForm.getLogin().isEmpty() || 
		   pessoaForm.getSenha() == null || pessoaForm.getSenha().isEmpty()){
			this.addMensagem("Preencha todos os campos", request);
			return mapping.findForward("deslogado");
		}
		
		Adminstrador admin = new AdminstradorDAO().verificarLogin(pessoaForm.getLogin(), pessoaForm.getSenha());
		
		if(admin == null){
			this.addMensagem("Login / Senha incorreto(s)", request);
			return mapping.findForward("deslogado");
		}
		
		request.getSession(true).setAttribute(CONS_ATTR_USER, admin);
		return mapping.findForward("logado");
	}
	
	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.getSession().invalidate();
		this.addMensagem("Você se deslogou com sucesso", request);
		return mapping.findForward("deslogado");
	}
	
	
}
