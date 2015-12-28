package br.com.analysis.modelo.constantes;

public enum ETamanhoCabecalho {
	
	TP_CLIENTE(2),
	NUM_CONTRATO_JURIDICO(10),
	DT_ENVIO_ARQUIVO(8),
	RAZAO_SOCIAL(50),
	NUM_CODIGO_REMESSA(5),
	DDD_TEL_COBRANCA(2),
	NUM_TEL_COBRACA(20), 
	COD_ADMINISTRATIVO(9),
	NUM_CARTAO_CLIENTE_POSTAGEM(9), 
	FORMA_PAGAMENTO(2);
	
	private int tamanho;
	
	private ETamanhoCabecalho(int tamanho){
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
