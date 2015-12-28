package br.com.bigdogsoftwares.uniserver.admin.form;

import org.apache.struts.action.ActionForm;

public class ProfessorForm extends ActionForm {

	private static final long serialVersionUID = -5260663396181113834L;

	private String nome;
	private String senha;
	private Long matricula;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getMatricula() {
		return matricula;
	}
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

}
