package br.com.analysis.modelo.constantes;

public enum ETamanhoDestinatario {

	TP_REGISTRO(2), 
	TITULO(50), 
	NOME(50), 
	AMBITO(1), 
	PEDIDO_COPIA(1),
	PEDIDO_CONFIRMACAO_ENTREGA(1), 
	DT_PRE_DATADO(8), 
	SIGLA_SERVICO(6), 
	INFO_ENTREGA(1),
	GRUPO(20), 
	COTA(20), 
	OBSERVACAO(50), 
	CABECALHO_MENSAGEM(60), 
	RODAPE_MENSAGEM(60),
	ENDERECAMENTO_SERVICO_ADICIONAL(1);
	
	private int tamanho;
	
	private ETamanhoDestinatario(int tamanho){
		this.tamanho = tamanho;
	}

	public int getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
}
