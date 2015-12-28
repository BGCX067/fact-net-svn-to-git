package br.com.analysis.modelo;

public class Cabecalho {

	private String 	tpCliente, 
					numContratoJuridico, 
					dtEnvioArquivo, 
					razaoSocial,
					numCodigoRemessa, 
					dddTelCobranca, 
					numTelCobraca, 
					codAdministrativo,
					numCartaoClientePostagem, 
					formaPagamento;

	public Cabecalho() {
		super();
	}

	public Cabecalho(String numCodigoRemessa, String dddTelCobranca,
			String numTelCobraca, String codAdministrativo,
			String numCartaoClientePostagem, String formaPagamento, String tpCliente,
			String numContratoJuridico, String dtEnvioArquivo,
			String razaoSocial) throws Exception {
		super();
		this.setNumCodigoRemessa(numCodigoRemessa);
		this.setDddTelCobranca(dddTelCobranca);
		this.setNumTelCobraca(numTelCobraca);
		this.setCodAdministrativo(codAdministrativo);
		this.setNumCartaoClientePostagem(numCartaoClientePostagem);
		this.setFormaPagamento(formaPagamento);
		this.setTpCliente(tpCliente);
		this.setNumContratoJuridico(numContratoJuridico);
		this.setDtEnvioArquivo(dtEnvioArquivo);
		this.setRazaoSocial(razaoSocial);
	}

	public String getNumCodigoRemessa() {
		return numCodigoRemessa;
	}

	public void setNumCodigoRemessa(String numCodigoRemessa) {
		this.numCodigoRemessa = numCodigoRemessa;
	}

	public String getDddTelCobranca() {
		return dddTelCobranca;
	}

	public void setDddTelCobranca(String dddTelCobranca) throws Exception {
		this.dddTelCobranca = dddTelCobranca;
	}

	public String getNumTelCobraca() {
		return numTelCobraca;
	}

	public void setNumTelCobraca(String numTelCobraca) {
		this.numTelCobraca = numTelCobraca;
	}

	public String getCodAdministrativo() {
		return codAdministrativo;
	}

	public void setCodAdministrativo(String codAdministrativo) {
		this.codAdministrativo = codAdministrativo;
	}

	public String getNumCartaoClientePostagem() {
		return numCartaoClientePostagem;
	}

	public void setNumCartaoClientePostagem(String numCartaoClientePostagem) {
		this.numCartaoClientePostagem = numCartaoClientePostagem;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getTpCliente() {
		return tpCliente;
	}

	public void setTpCliente(String tpCliente) {
		this.tpCliente = tpCliente;
	}

	public String getNumContratoJuridico() {
		return numContratoJuridico;
	}

	public void setNumContratoJuridico(String numContratoJuridico) {
		this.numContratoJuridico = numContratoJuridico;
	}

	public String getDtEnvioArquivo() {
		return dtEnvioArquivo;
	}

	public void setDtEnvioArquivo(String dtEnvioArquivo) {
		this.dtEnvioArquivo = dtEnvioArquivo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return "Cabecalho [numCodigoRemessa=" + numCodigoRemessa
				+ ", dddTelCobranca=" + dddTelCobranca + ", numTelCobraca="
				+ numTelCobraca + ", codAdministrativo=" + codAdministrativo
				+ ", numCartaoClientePostagem=" + numCartaoClientePostagem
				+ ", formaPagamento=" + formaPagamento + ", tpCliente="
				+ tpCliente + ", numContratoJuridico=" + numContratoJuridico
				+ ", dtEnvioArquivo=" + dtEnvioArquivo + ", razaoSocial="
				+ razaoSocial + "]";
	}

}
