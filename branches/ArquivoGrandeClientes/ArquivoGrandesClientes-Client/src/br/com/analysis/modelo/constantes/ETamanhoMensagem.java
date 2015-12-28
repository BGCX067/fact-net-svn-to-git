package br.com.analysis.modelo.constantes;

public enum ETamanhoMensagem {
	
	TP_REGISTRO(2);
	
	private int tamanho;

	private ETamanhoMensagem(int tamanho){
		this.tamanho = tamanho;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	

}
