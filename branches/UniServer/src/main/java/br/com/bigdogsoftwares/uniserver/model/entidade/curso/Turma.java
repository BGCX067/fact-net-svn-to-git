package br.com.bigdogsoftwares.uniserver.model.entidade.curso;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Implementa atributos referentes a turma que determinado aluno pertence
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */
@Entity
@Table(name="tbTurma")
public class Turma {

	@Column(insertable=true, nullable=false, updatable=true)
	private int noSala;
	
	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="auto")
	@Column(nullable=false, updatable=false)
	private long id;
	
	/**
	 * Indica qual o ano e letra do curso. por ex: 5A
	 */
	@Column(length=5, insertable=true, nullable=false, updatable=true)
	private String turma;
	
	@ManyToMany
	private List<Disciplina> disciplinas;
	
	@OneToOne
	@JoinColumn(name="idCurso", nullable=false, insertable=true)
	private Curso curso;
	
	public int getNoSala() {
		return noSala;
	}
	public void setNoSala(int noSala) {
		this.noSala = noSala;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}