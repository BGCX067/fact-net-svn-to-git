package br.org.missaoart.gerenciador.dao.membros.entinty;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="pessoa")
public class PessoaEntinty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idPessoa", length=10, columnDefinition="INT")
	private Long idPessoa;
	
	@Column(name="nome",nullable = false, length=50)
	private String nmPessoa;
	
	@Column(name="dtNascimento",nullable = false, columnDefinition="DATE")
	private Date dtNasc;
	
	@Column(name="rg",nullable = false, length=12)
	private String nuIdentidade;
	
	@Column(name="telefone", nullable=true, length=10, columnDefinition="INT")
	private Long nuTelefone;
	
	@Column(name="celular", nullable=true, length=11, columnDefinition="INT")
	private Long nuCelular;
	
	@Column(name="email", nullable=true, length=50)
	private String email;
	
	@Column(name="tpPessoa",nullable = false, length=20)
	private String tpPessoa;
	
	@Column(name="login", nullable=true, length=20)
	private String login;
	
	@Column(name="senha", nullable=true, length=50)
	private String senha;
	
	@Column(name="ministerio", nullable=true, length=50)
	private String ministerio;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},optional=true)
	@JoinColumn(name="membroPrincipal", nullable = true, columnDefinition = "INT")
	private PessoaEntinty membroPrincipal;
	
	@OneToOne(cascade={CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="endereco", columnDefinition = "INT")
	private EnderecoEntinty endereco;
	
	public PessoaEntinty(){}
	
	public PessoaEntinty(Long idPessoa){
		this.idPessoa = idPessoa;
	}
	
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNmPessoa() {
		return nmPessoa;
	}
	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getNuIdentidade() {
		return nuIdentidade;
	}
	public void setNuIdentidade(String nuIdentidade) {
		this.nuIdentidade = nuIdentidade;
	}
	public Long getNuTelefone() {
		return nuTelefone;
	}
	public void setNuTelefone(Long nuTelefone) {
		this.nuTelefone = nuTelefone;
	}
	public Long getNuCelular() {
		return nuCelular;
	}
	public void setNuCelular(Long nuCelular) {
		this.nuCelular = nuCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTpPessoa() {
		return tpPessoa;
	}
	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}
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
	public String getMinisterio() {
		return ministerio;
	}
	public void setMinisterio(String ministerio) {
		this.ministerio = ministerio;
	}
	public PessoaEntinty getMembroPrincipal() {
		return membroPrincipal;
	}
	public void setMembroPrincipal(PessoaEntinty membroPrincipal) {
		this.membroPrincipal = membroPrincipal;
	}
	public EnderecoEntinty getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoEntinty endereco) {
		this.endereco = endereco;
	}
}
