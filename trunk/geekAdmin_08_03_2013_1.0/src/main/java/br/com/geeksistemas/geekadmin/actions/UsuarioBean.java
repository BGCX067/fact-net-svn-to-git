package br.com.geeksistemas.geekadmin.actions;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.com.geeksistemas.geekadmin.domainobjects.Usuario;

@ManagedBean(name="usuario")
@SessionScoped
public class UsuarioBean {
	
	private Usuario info = new Usuario();
	private boolean exibeMenu = false, exibeGuardarPergunta = true;
	
	public void atualizarDados(ActionEvent event){
		this.exibeMenu = false;
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Realizado com sucesso !", "Atualização realizada com sucesso"));
	}
	
	public void atualizarPergunta(ActionEvent event){
		System.out.println("Validando dados da pergunta secreta");
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(info.getPassword().equals(info.getOldPassword())){
			info.setRespostaSecreta(info.getNewRespostaSecreta());
			info.setPerguntaSecreta(info.getNewPerguntaSecreta());
			exibeGuardarPergunta = false;
			context.addMessage("pergunta_message", new FacesMessage(FacesMessage.SEVERITY_INFO, "Resposta e Pergunta guardadas com sucesso",""));
		}else{
			context.addMessage("pergunta_message", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Senha informada invalida", "As informações não foram guardadas"));
		}
	}
	
	public void atualizarSenha(){
		System.out.println("Validando dados da senha");
		FacesContext context = FacesContext.getCurrentInstance();
		
		boolean senhaConfere = false, senhaConfirmada = false;
		
		if(info.getPassword().equals(info.getOldPassword())){
			senhaConfere = true;
		}
		if(info.getNewPassword().equals(info.getConfirmNewPassword())){
			senhaConfirmada = true;
		}
		
		if(!senhaConfere){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
									 "A senha antiga é invalida", "A antiga senha não confere"));
			info.setNewPassword("");
			info.setOldPassword("");
			info.setConfirmNewPassword("");
		}else if(!senhaConfirmada){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
									 "A nova senha e a confirmação são diferentes.", ""));
			info.setNewPassword("");
			info.setOldPassword("");
			info.setConfirmNewPassword("");
		}else{
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					 "Informações guardadas com sucesso", ""));
			info.setOldPassword("");
			info.setConfirmNewPassword("");
			//TODO: Na hora de salvar a nova senha, utililar o 
			//atributo password como filtro e o newPassword na clausula set password.
		}
		
	}
	
	public void deslogar(){

	}

	public Usuario getInfo() {
		return info;
	}

	public void setInfo(Usuario info) {
		this.info = info;
	}

	public boolean isExibeMenu() {
		return exibeMenu;
	}

	public void setExibeMenu(boolean exibeMenu) {
		this.exibeMenu = exibeMenu;
	}
	
	public void exibeSalvar(){
		this.exibeMenu = true;
	}

	public boolean isExibeGuardarPergunta() {
		return exibeGuardarPergunta;
	}

	public void setExibeGuardarPergunta(boolean exibeGuardarPergunta) {
		this.exibeGuardarPergunta = exibeGuardarPergunta;
	}
	
	

}
