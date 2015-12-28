package br.com.analysis.modelo;

public class Endereco {

	private String 	tpLogradouro, 
					logradouro,
					numLogradouro,
					complemento, 
					bairro, 
					localidade,
					UF, 
					CEP, 
					email, 
					pais;

	public Endereco() {
		super();
	}

	public Endereco(String tpLogradouro, String logradouro,String numLogradouro, String complemento,
			String bairro, String localidade, String UF, String CEP,
			String email, String pais) {
		super();
		this.setTpLogradouro(tpLogradouro);
		this.setLogradouro(logradouro);
		this.setNumLogradouro(numLogradouro);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setLocalidade(localidade);
		this.setUF(UF);
		this.setCEP(CEP);
		this.setEmail(email);
		this.setPais(pais);
	}

	public String getTpLogradouro() {
		return tpLogradouro;
	}

	public void setTpLogradouro(String tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(String numLogradouro) {
		this.numLogradouro = numLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [tpLogradouro=" + tpLogradouro + ", logradouro="
				+ logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", localidade=" + localidade + ", UF=" + UF
				+ ", CEP=" + CEP + ", email=" + email + ", pais=" + pais + "]";
	}
}
