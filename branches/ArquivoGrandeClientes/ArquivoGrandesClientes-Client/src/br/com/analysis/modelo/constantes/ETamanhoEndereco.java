package br.com.analysis.modelo.constantes;

public enum ETamanhoEndereco {
	
	
	TP_LOGRADOURO(25), 
	LOGRADOURO(72), 
	NUM_LOGRADOURO(6),
	COMPLEMENTO(30), 
	BAIRRO(72), 
	LOCALIDADE(72),
	UF(2), 
	CEP(10), 
	EMAIL(50), 
	PAIS(50);
	
	private int tamanho;
	
	private ETamanhoEndereco(int tamanho){
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

}
