/**
 * 
 */
package br.com.bigdogsoftwares.uniserver.controller.form;

import org.apache.struts.action.ActionForm;

import br.com.bigdogsoftwares.uniserver.model.entidade.pessoa.Pessoa;

/**
 * @author jborba
 * 
 */
public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2822497275370614618L;

	private Pessoa pessoa;

	public LoginForm() {
		pessoa = new Pessoa();
	}

	public String getNome() {
		return pessoa.getNome();
	}

	public void setNome(String nome) {
		this.pessoa.setNome(nome);
	}

	public String getSenha() {
		return this.pessoa.getSenha();
	}

	public void setSenha(String senha) {
		this.pessoa.setSenha(senha);
	}

	public Long getMatricula() {
		return this.pessoa.getMatricula();
	}

	public void setMatricula(Long matricula) {
		this.pessoa.setMatricula(matricula);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

}
