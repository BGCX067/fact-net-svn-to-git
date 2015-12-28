package uninove.factnet.datatypes.rh;

import uninove.factnet.datatypes.autenticacao.Permissoes;
import uninove.factnet.datatypes.login.Login;

public class Pessoa {
	
	
	private Long idPessoa;
	private Boolean isAtivo;
	private Boolean isFuncionario;
	private Login login;
	private String nome;
	private Permissoes permissoes;
	
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public Pessoa(Login login) {
		this.login = login;
	}
	
	
	public Long getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	public Boolean getIsAtivo() {
		return isAtivo;
	}
	
	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
	
	public Boolean getIsFuncionario() {
		return isFuncionario;
	}
	
	public void setIsFuncionario(Boolean isFuncionario) {
		this.isFuncionario = isFuncionario;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
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
	
}
