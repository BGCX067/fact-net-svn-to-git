package br.com.bigdogsoftwares.uniserver.model.entidade.notificaoes;

import java.util.Date;

import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Disciplina;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Turma;

/**
 * @author Cristiano
 * @version 1.0
 * @created 15-ago-2013 12:45:42
 */
public class AnotacaoProfessor {

	private String anotacao;
	private Date data;
	private Disciplina disciplina;
	private Long id;
	private Turma turma;

	public AnotacaoProfessor(){

	}

	public String getAnotacao() {
		return anotacao;
	}

	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}