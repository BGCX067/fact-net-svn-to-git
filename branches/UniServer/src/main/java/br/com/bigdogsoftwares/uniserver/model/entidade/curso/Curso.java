package br.com.bigdogsoftwares.uniserver.model.entidade.curso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Classe que implementa os atributos referentes ao Curso que determianda pessoa
 * faz.
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */

@Entity
@Table(name="tbCurso")
public class Curso {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="auto")
	@Column(nullable=false, updatable=false)
	private long id;
	
	@Column(name="nmCurso", nullable=false, insertable=true)
	private String nome;
	
	
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
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	


}
