package br.com.bigdogsoftwares.uniserver.model.entidade.notificaoes;

import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Disciplina;
import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Turma;
import br.com.bigdogsoftwares.uniserver.model.util.EDiaSemana;


/**
 * @author Cristiano
 * @version 1.0
 * @created 15-ago-2013 12:45:42
 */
public class Horario {

	private EDiaSemana diaSemana;
	private Disciplina disciplina; //Equivalente a Materia
	private Long id;
	private Turma turma;

	public Horario(){

	}

	public EDiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(EDiaSemana diaSemana) {
		this.diaSemana = diaSemana;
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