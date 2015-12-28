package uninove.factnet.datatypes.login;

public class Login {
	
	//Indexes dos campos referente a posição deles na tela
	public static final int LOGIN = 0;
	public static final int SENHA = 1;
	public static final int RECUPERAR_SENHA = 2;
	
	private String login;
	private String senha;
	private boolean isRecuperarSenha;
	private String email;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isRecuperarSenha() {
		return isRecuperarSenha;
	}
	public void setRecuperarSenha(boolean isRecuperarSenha) {
		this.isRecuperarSenha = isRecuperarSenha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
