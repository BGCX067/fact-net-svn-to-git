package br.com.bigdogsoftwares.uniserver.admin.form;

import org.apache.struts.action.ActionForm;

import br.com.bigdogsoftwares.uniserver.model.entidade.admin.Permissoes;

public class PessoaForm extends ActionForm{
	
	private static final long serialVersionUID = -4196313497634998283L;
	
	public String login;
	public String senha;
	public String nome;
	public Permissoes permissoes;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	
	

}
