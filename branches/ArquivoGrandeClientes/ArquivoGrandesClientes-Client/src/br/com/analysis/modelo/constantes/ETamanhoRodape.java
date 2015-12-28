package br.com.analysis.modelo.constantes;

public enum ETamanhoRodape {
	
	INDENTIFICADOR_LINHA_RODAPE(1), 
	NUM_REGISTRO(8), 
	NUM_TELEGRAMAS(8);
	
	private int tamanho;
	
	private ETamanhoRodape(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	

}
