package br.com.bigdogsoftwares.uniserver.model.entidade.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Professor;

/**
 * Classe que implementa atributos referentes a máterias
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */

@Entity
@Table(name="tbDisciplina")
public class Disciplina {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="auto")
	@Column(nullable=false, updatable=false)
	private long id;
	
	@Column(name="nmDisciplina", nullable=false, length=50, updatable=true)
	private String nome;
	
	@Column(insertable=true, nullable=false)
	private String descricao;
	
	@OneToOne
	@JoinColumn(name="idProfessor", nullable=false, insertable=true)
	private Professor professor;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCursoAlvo", nullable=false, insertable=true)
	private Curso cursoAlvo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Curso getCursoAlvo() {
		return cursoAlvo;
	}
	public void setCursoAlvo(Curso cursoAlvo) {
		this.cursoAlvo = cursoAlvo;
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
		Disciplina other = (Disciplina) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
}