/**
 * 
 */
package uninove.factnet.comercial.rh.form;

import org.apache.struts.action.ActionForm;

/**
 * Classe POJO com os atributos do formulario de cadastro (WEB)
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public class CadastroClienteForm extends ActionForm {

	private static final long serialVersionUID = -8527723348101217930L;
	
	//PESSOAL
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private char sexo;
	
	//CONTATO
	private String nuTelefone;
	private String pais;
	private String cidade;
	private String endereco;
	private String cep;
	private Integer nuCasa;
	private String email;

	//SEGURANÇA
	private String senha;
	private Integer meioInclusao;
	
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * @return the dataNascimento
	 */
	public String getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the nuTelefone
	 */
	public String getNuTelefone() {
		return nuTelefone;
	}
	/**
	 * @param nuTelefone the nuTelefone to set
	 */
	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the nuCasa
	 */
	public Integer getNuCasa() {
		return nuCasa;
	}
	/**
	 * @param nuCasa the nuCasa to set
	 */
	public void setNuCasa(Integer nuCasa) {
		this.nuCasa = nuCasa;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getMeioInclusao() {
		return meioInclusao;
	}
	public void setMeioInclusao(Integer meioInclusao) {
		this.meioInclusao = meioInclusao;
	}
	
	
}
