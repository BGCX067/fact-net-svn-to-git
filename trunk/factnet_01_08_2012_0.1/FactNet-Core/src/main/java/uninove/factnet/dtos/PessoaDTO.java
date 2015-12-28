/**
 * 
 */
package uninove.factnet.dtos;

import uninove.factnet.enums.ETipoPessoa;

/**
 * Representa a entidade "Pessoa" no sistema, pode ser extendido para um tipo
 * mais generico de pessoa. 
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 * 
 */
public class PessoaDTO {
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String emailLogin;
	private String senha;
	private ETipoPessoa tipoPessoa;
	private PermissaoVO permissoes;
	
	public PessoaDTO() {}
	
	public PessoaDTO(String nome, ETipoPessoa tipoPessoa, PermissaoVO permissoes){
		this.nome = nome;
		this.tipoPessoa = tipoPessoa;
		this.permissoes = permissoes;
	}
	
	
	
	
	/**
	 * Retorna o id da pessoa
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Altera o id da pessoa
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Retorna o nome
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Altera o nome do objeto
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna o emailLogin
	 * @return the emailLogin
	 */
	public String getEmailLogin() {
		return emailLogin;
	}
	/**
	 * Atera o emailLogin do objeto
	 * @param emailLogin the emailLogin to set
	 */
	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}
	/**
	 * Retorna a senha
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * Atera a senha do objeto
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * Retorna as permissões do usuario
	 * @return the permissoes
	 */
	public PermissaoVO getPermissoes() {
		return permissoes;
	}
	/**
	 * Altera o objeto PermissaoDTO
	 * @param permissoes the permissoes to set
	 */
	public void setPermissoes(PermissaoVO permissoes) {
		this.permissoes = permissoes;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the tipoPessoa
	 */
	public ETipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	/**
	 * @param tipoPessoa the tipoPessoa to set
	 */
	public void setTipoPessoa(ETipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
