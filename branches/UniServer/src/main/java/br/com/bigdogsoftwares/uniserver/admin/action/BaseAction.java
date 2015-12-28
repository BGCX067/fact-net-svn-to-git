package br.com.bigdogsoftwares.uniserver.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BaseAction extends DispatchAction{

	public static final String CONS_ATTR_MESSAGE = "message";
	public static final String CONS_ATTR_USER = "adminstrador";
	
	public void addMensagem(String mensagem, HttpServletRequest request){
		request.setAttribute(CONS_ATTR_MESSAGE, mensagem);
	}
	
	public void addAjaxError(HttpServletResponse response, String errorMessage)throws Exception{
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		response.getWriter().write(errorMessage);
		response.getWriter().flush();
	}
	
	public void addAjaxInfo(HttpServletResponse response, String infoMessage)throws Exception{
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(infoMessage);
		response.getWriter().flush();
	}
	
	
	public ActionForward isLogado(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, boolean isAjax)
			throws Exception {
		
		boolean isDeslogado = request.getSession().getAttribute(CONS_ATTR_USER) == null;
		
		if(!isDeslogado){
			return null;			
		}
		
		if(isAjax){
			addAjaxError(response, "Efetue login para continuar");
			return mapping.findForward("deslogado");
		}else{
			return mapping.findForward("deslogado");
		}
	}
}
