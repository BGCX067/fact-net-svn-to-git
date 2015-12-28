package br.com.bigdogsoftwares.uniserver.model.entidade.pessoa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Classe que implementa atributos necessários para identificação do usuario do
 * sistema
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */

@Entity
@Table(name="tbPessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa{

	@Column(name="nmPessoa", length=50, nullable=false, insertable=true)
	private String nome;
	
	@Column(name="senha", length=50, nullable=false, insertable=true)
	private String senha;
	
	@Id
	@Column(name="noMatricula", nullable=false, unique=true, insertable=true, updatable=false)
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (matricula ^ (matricula >>> 32));
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
		Pessoa other = (Pessoa) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}

	
	

}