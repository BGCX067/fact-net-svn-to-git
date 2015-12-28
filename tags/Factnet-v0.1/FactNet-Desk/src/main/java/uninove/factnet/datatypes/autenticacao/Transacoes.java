package uninove.factnet.datatypes.autenticacao;

import java.util.HashMap;

public class Transacoes {
	
	
	private final HashMap<String, String> listaTransacao = new HashMap<String, String>();
	
	public void addTransacao(String chave, String trancacao){
		listaTransacao.put(chave, trancacao);
	}
	
	public String getTransacao(String chave){
		return listaTransacao.get(chave);
	}
}
