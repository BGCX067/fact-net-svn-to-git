package br.com.bigdogsoftwares.uniserver.model.entidade.admin;

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

/**
 * @author Cristiano
 * @version 1.0
 * @created 10-ago-2013 13:45:27
 */
@Entity
@Table(name="tbAdminstrador")
public class Adminstrador {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="auto")
	@Column(name="id", nullable=false, updatable=false)
	private long id;
	
	@Column(insertable=true, length=50, nullable=false, updatable=false)
	private String login;
	
	@Column(insertable=true, length=50, nullable=false, updatable=true)
	private String nome;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPermissoes", insertable=true, updatable=false, nullable=false, unique=true)
	private Permissoes permissoes;
	
	@Column(insertable=true, length=50, nullable=false, updatable=true)
	private String senha;

	public Adminstrador(){

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Adminstrador other = (Adminstrador) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}