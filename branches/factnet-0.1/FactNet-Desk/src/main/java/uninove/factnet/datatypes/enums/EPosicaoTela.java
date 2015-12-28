package uninove.factnet.datatypes.enums;

public enum EPosicaoTela {
	
	CONTEUDO(1);
	
	int id;
	
	private EPosicaoTela(int id){
		this.id = id;
	}
	
	public EPosicaoTela parse(int id){
		EPosicaoTela ePosicaoTela = null;
		if(id == EPosicaoTela.CONTEUDO.id){
			ePosicaoTela = EPosicaoTela.CONTEUDO;
		}
		return ePosicaoTela;
	}
}
