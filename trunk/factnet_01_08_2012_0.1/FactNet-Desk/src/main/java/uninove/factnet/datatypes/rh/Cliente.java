package uninove.factnet.datatypes.rh;

import uninove.factnet.datatypes.login.Login;

public class Cliente extends Pessoa{
	
	private String endereco;
//	private List<HistoricoVenda> historicoCompras;
	private Boolean isAtivo;
	private String telefone;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Login login) {
		super(login);
	}

	public Cliente(Long idPessoa) {
		super(idPessoa);
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail(){
		if(super.getLogin() != null ){
			return super.getLogin().getEmail();
		}
		return null;
	}
	
	public void setEmail(String email){
		if(super.getLogin() != null ){
			super.getLogin().setEmail(email);
		}
	}

}
