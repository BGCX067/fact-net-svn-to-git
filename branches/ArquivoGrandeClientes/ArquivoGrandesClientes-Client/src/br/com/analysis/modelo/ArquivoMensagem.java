package br.com.analysis.modelo;

import java.util.List;

public class ArquivoMensagem {

	private Cabecalho cabecalho;
	private List<Remetente> listaRemetente;
	private Imagem imagem;
	private Rodape rodape;

	public ArquivoMensagem() {
		super();
	}

	public ArquivoMensagem(Cabecalho cabecalho, List<Remetente> listaRemetente, Rodape rodape) {
		super();
		this.setCabecalho(cabecalho);
		this.setListaRemetente(listaRemetente);
		this.setRodape(rodape);
	}

	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public void setCabecalho(Cabecalho cabecalho) {
		this.cabecalho = cabecalho;
	}

	public List<Remetente> getListameRemetente() {
		return listaRemetente;
	}

	public void setListaRemetente(List<Remetente> listaRemetente) {
		this.listaRemetente = listaRemetente;
	}
	
	public Rodape getRodape() {
		return rodape;
	}

	public void setRodape(Rodape rodape) {
		this.rodape = rodape;
	}

	@Override
	public String toString() {
		return "ArquivoMensagem [cabecalho=" + cabecalho + ", listaRemetente="
				+ listaRemetente + ", imagem=" + imagem + ", rodape=" + rodape
				+ "]";
	}
}
