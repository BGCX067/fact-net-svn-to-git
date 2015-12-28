package br.com.geeksistemas.geekadmin.domainobjects;

import java.util.Date;

import br.com.geeksistemas.geekadmin.datatypes.GeekDate;

public class Usuario {
	
	//Identificação do Sistema
	private Integer id;
	private String login;
	private String tipoUsuario;
	
	//Identificação de Pessoa
	private String nome;
	private String sobrenome;
	private Date dataNasc;
	private String RG;
	private String CPF;
	
	//Contato
	private String email;
	private String telefone;
	
	//Segurança
	private String password;
	private String perguntaSecreta;
	private String respostaSecreta;
	
	//Alteração de Dados - Dados que necessitam serem confirmados
	private String oldPassword;
	private String newPassword;
	private String confirmNewPassword;
	private String newPerguntaSecreta;
	private String newRespostaSecreta;
	
	public Usuario() {
		mockValues();
	}
	
	private void mockValues(){
		this.CPF = "123.456.789-10";
		this.dataNasc = new GeekDate(new Date().getTime());
		this.email = "teste@email.com";
		this.id = 2;
		this.login = "Mock";
		this.nome = "Mock User";
		this.password = "mock";
		this.perguntaSecreta = "Qual o nome da sua mãe ?";
		this.respostaSecreta = "Mockita";
		this.RG = "12.345.678-9";
		this.sobrenome = "Test de login";
		this.telefone = "(11) 91234-5678";
		this.tipoUsuario = "Adminstrador";
		
		this.newPerguntaSecreta = this.perguntaSecreta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(!login.isEmpty())
		this.login = login;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		if(!tipoUsuario.isEmpty())
			this.tipoUsuario = tipoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(!nome.isEmpty())
			this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		if(!sobrenome.isEmpty())
			this.sobrenome = sobrenome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		
		this.dataNasc = new GeekDate(dataNasc.getTime());
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		if(!rG.isEmpty())
			RG = rG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		if(!cPF.isEmpty())
			CPF = cPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(!email.isEmpty())
			this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(!telefone.isEmpty())
			this.telefone = telefone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(!password.isEmpty())
			this.password = password;
	}

	public String getPerguntaSecreta() {
		return perguntaSecreta;
	}

	public void setPerguntaSecreta(String perguntaSecreta) {
		if(!perguntaSecreta.isEmpty())
			this.perguntaSecreta = perguntaSecreta;
	}

	public String getRespostaSecreta() {
		return respostaSecreta;
	}

	public void setRespostaSecreta(String respostaSecreta) {
		if(!respostaSecreta.isEmpty())
			this.respostaSecreta = respostaSecreta;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}

	public String getNewPerguntaSecreta() {
		return newPerguntaSecreta;
	}

	public void setNewPerguntaSecreta(String newPerguntaSecreta) {
		this.newPerguntaSecreta = newPerguntaSecreta;
	}

	public String getNewRespostaSecreta() {
		return newRespostaSecreta;
	}

	public void setNewRespostaSecreta(String newRespostaSecreta) {
		this.newRespostaSecreta = newRespostaSecreta;
	}
	
	
}
