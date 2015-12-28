package br.com.analysis.modelo;

import java.util.List;


public class Remetente {

	private String tpRegistro, 
				   titulo, 
				   nome;
	private Endereco endereco;
	private List<Mensagem> mensagens;

	public Remetente() {
		super();
	}

	public Remetente(String tpRegistro, String titulo, String nome,Endereco endereco) throws Exception {
		super();
		this.setTpRegistro(tpRegistro);
		this.setTitulo(titulo);
		this.setNome(nome);
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	@Override
	public String toString() {
		return "Remetente [tpRegistro=" + tpRegistro + ", titulo=" + titulo
				+ ", nome=" + nome + ", endereco=" + endereco + "]";
	}
}
