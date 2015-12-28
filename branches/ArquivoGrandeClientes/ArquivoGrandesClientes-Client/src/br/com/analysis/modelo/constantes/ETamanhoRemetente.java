package br.com.analysis.modelo.constantes;

public enum ETamanhoRemetente {
	
	TP_REGISTRO(2),
	TITULO(50),
	NOME(50);
	
	private int tamanho;
	
	private ETamanhoRemetente(int tamanho){
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
}
