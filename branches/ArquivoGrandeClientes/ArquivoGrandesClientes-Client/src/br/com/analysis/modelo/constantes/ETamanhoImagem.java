package br.com.analysis.modelo.constantes;

public enum ETamanhoImagem {
	
	TP_REGISTRO(2),
	COD_IMAGEM_TOPO(9),
	COD_IMAGEM_RODAPE(9);
	
	private int tamanho;

	private ETamanhoImagem(int tamanho){
		this.tamanho = tamanho;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
