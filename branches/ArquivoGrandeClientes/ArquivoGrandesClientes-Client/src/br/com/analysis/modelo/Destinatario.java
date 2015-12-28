package br.com.analysis.modelo;

public class Destinatario {

	private String 	tpRegistro, 
					titulo, 
					nome, 
					ambito, 
					pedidoCopia,
					pedidoConfirmacaoEntrega, 
					dtPreDatado, 
					siglaServico, 
					infoEntrega,
					grupo, 
					cota, 
					observacao, 
					cabecalhoMensagem, 
					rodapeMensagem,
					enderecamentoServicoAdicional;
	
	private Endereco endereco;
	
	public Destinatario() {
		super();
	}
	
	

	public Destinatario(String tpRegistro, String titulo, String nome,
			String ambito, String pedidoCopia, String pedidoConfirmacaoEntrega,
			String dtPreDatado, String siglaServico, String infoEntrega,
			String grupo, String cota, String observacao,
			String cabecalhoMensagem, String rodapeMensagem,
			String enderecamentoServicoAdicional, Endereco endereco)throws Exception {
		super();
		this.setTpRegistro(tpRegistro);
		this.setTitulo(titulo);
		this.setNome(nome);
		this.setAmbito(ambito);
		this.setPedidoCopia(pedidoCopia);
		this.setPedidoConfirmacaoEntrega(pedidoConfirmacaoEntrega);
		this.setDtPreDatado(dtPreDatado);
		this.setSiglaServico(siglaServico);
		this.setInfoEntrega(infoEntrega);
		this.setGrupo(grupo);
		this.setCota(cota);
		this.setObservacao(observacao);
		this.setCabecalhoMensagem(cabecalhoMensagem);
		this.setRodapeMensagem(rodapeMensagem);
		this.setEnderecamentoServicoAdicional(enderecamentoServicoAdicional);
		this.setEndereco(endereco);
	}

	public String getTpRegistro() {
		return tpRegistro;
	}

	public void setTpRegistro(String tpRegistro) {
		this.tpRegistro = tpRegistro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAmbito() {
		return ambito;
	}

	public void setAmbito(String ambito) {
		this.ambito = ambito;
	}

	public String getPedidoCopia() {
		return pedidoCopia;
	}

	public void setPedidoCopia(String pedidoCopia) {
		this.pedidoCopia = pedidoCopia;
	}

	public String getPedidoConfirmacaoEntrega() {
		return pedidoConfirmacaoEntrega;
	}

	public void setPedidoConfirmacaoEntrega(String pedidoConfirmacaoEntrega) {
		this.pedidoConfirmacaoEntrega = pedidoConfirmacaoEntrega;
	}

	public String getDtPreDatado() {
		return dtPreDatado;
	}

	public void setDtPreDatado(String dtPreDatado) {
		this.dtPreDatado = dtPreDatado;
	}

	public String getSiglaServico() {
		return siglaServico;
	}

	public void setSiglaServico(String siglaServico) {
		this.siglaServico = siglaServico;
	}

	public String getInfoEntrega() {
		return infoEntrega;
	}

	public void setInfoEntrega(String infoEntrega) {
		this.infoEntrega = infoEntrega;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCota() {
		return cota;
	}

	public void setCota(String cota) {
		this.cota = cota;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCabecalhoMensagem() {
		return cabecalhoMensagem;
	}

	public void setCabecalhoMensagem(String cabecalhoMensagem) {
		this.cabecalhoMensagem = cabecalhoMensagem;
	}

	public String getRodapeMensagem() {
		return rodapeMensagem;
	}

	public void setRodapeMensagem(String rodapeMensagem) {
		this.rodapeMensagem = rodapeMensagem;
	}

	public String getEnderecamentoServicoAdicional() {
		return enderecamentoServicoAdicional;
	}

	public void setEnderecamentoServicoAdicional(
			String enderecamentoServicoAdicional) {
		this.enderecamentoServicoAdicional = enderecamentoServicoAdicional;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Destinatario [tpRegistro=" + tpRegistro + ", titulo=" + titulo
				+ ", nome=" + nome + ", ambito=" + ambito + ", pedidoCopia="
				+ pedidoCopia + ", pedidoConfirmacaoEntrega="
				+ pedidoConfirmacaoEntrega + ", dtPreDatado=" + dtPreDatado
				+ ", siglaServico=" + siglaServico + ", infoEntrega="
				+ infoEntrega + ", grupo=" + grupo + ", cota=" + cota
				+ ", observacao=" + observacao + ", cabecalhoMensagem="
				+ cabecalhoMensagem + ", rodapeMensagem=" + rodapeMensagem
				+ ", enderecamentoServicoAdicional="
				+ enderecamentoServicoAdicional + ", endereco=" + endereco
				+ "]";
	}
}
