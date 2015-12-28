package br.com.bigdogsoftwares.uniserver.admin.form;

import org.apache.struts.action.ActionForm;

public class TurmaForm extends ActionForm{

	private static final long serialVersionUID = 2375094146939693360L;

	private int noSala;
	private String turma;
	private Long disciplinas[];
	private Long curso;
	
	public int getNoSala() {
		return noSala;
	}
	public void setNoSala(int noSala) {
		this.noSala = noSala;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public Long[] getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Long disciplinas[]) {
		this.disciplinas = disciplinas;
	}
	public Long getCurso() {
		return curso;
	}
	public void setCurso(Long curso) {
		this.curso = curso;
	}
}
