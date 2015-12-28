package br.com.analysis.modelo;

import java.util.List;

public class Mensagem {
	
	private String tpRegistro,mensagem;
	private List<Destinatario> listaDestinatario;
	private Imagem imagem;
	

	public Mensagem() {
		super();
	}

	public Mensagem(String tpRegistro, String mensagem,
			List<Destinatario> listaDestinatario, List<Remetente> listaRemetente) {
		super();
		this.setTpRegistro(tpRegistro);
		this.setMensagem(mensagem);
		this.setListaDestinatario(listaDestinatario);
	}

	public String getTpRegistro() {
		return tpRegistro;
	}

	public void setTpRegistro(String tpRegistro) {
		this.tpRegistro = tpRegistro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Destinatario> getListaDestinatario() {
		return listaDestinatario;
	}

	public void setListaDestinatario(List<Destinatario> listaDestinatario) {
		this.listaDestinatario = listaDestinatario;
	}

	@Override
	public String toString() {
		return "Mensagem [tpRegistro=" + tpRegistro + ", mensagem=" + mensagem
				+ ", listaDestinatario=" + listaDestinatario
				+ ", imagem=" + imagem + "]";
	}
	
}
