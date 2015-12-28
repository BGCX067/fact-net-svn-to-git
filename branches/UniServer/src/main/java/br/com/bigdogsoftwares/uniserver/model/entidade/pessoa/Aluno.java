package br.com.bigdogsoftwares.uniserver.model.entidade.pessoa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.bigdogsoftwares.uniserver.model.entidade.curso.Turma;


/**
 * Implementa atributos do aluno
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */

@Entity
@Table(name="tbAluno")
@PrimaryKeyJoinColumn(name="matricula")
public class Aluno extends Pessoa {
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idTurma", insertable=true, updatable=true, nullable=false, unique=false)
	private Turma turma;

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}