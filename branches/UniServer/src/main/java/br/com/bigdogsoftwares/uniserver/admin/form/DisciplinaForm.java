package br.com.bigdogsoftwares.uniserver.admin.form;

import org.apache.struts.action.ActionForm;

public class DisciplinaForm extends ActionForm{
	
	private static final long serialVersionUID = 8741554874891780704L;
	
	private String nome;
	private String descricao;
	private Long matriculaProfessor;
	private Long cursoAlvo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getMatriculaProfessor() {
		return matriculaProfessor;
	}
	public void setMatriculaProfessor(Long matriculaProfessor) {
		this.matriculaProfessor = matriculaProfessor;
	}
	public Long getCursoAlvo() {
		return cursoAlvo;
	}
	public void setCursoAlvo(Long cursoAlvo) {
		this.cursoAlvo = cursoAlvo;
	}
	
	
	
	
}
