package uninove.factnet.datatypes.autenticacao;

public class Permissoes {
	
	private Boolean isAcessaAssistencia = false;
	private Boolean isAcessaComercial = false;
	private Boolean isAcessaEstoque = false;
	private Boolean isAcessaRH = false;
	private Boolean isAcessaVendas = false;
	private Transacoes transacoes;
	
	public Boolean isAcessaAssistencia() {
		return isAcessaAssistencia;
	}
	
	public void setIsAcessaAssistencia(Boolean isAcessaAssistencia) {
		this.isAcessaAssistencia = isAcessaAssistencia;
	}
	
	public Boolean isAcessaComercial() {
		return isAcessaComercial;
	}
	
	public void setIsAcessaComercial(Boolean isAcessaComercial) {
		this.isAcessaComercial = isAcessaComercial;
	}
	
	public Boolean isAcessaEstoque() {
		return isAcessaEstoque;
	}
	
	public void setIsAcessaEstoque(Boolean isAcessaEstoque) {
		this.isAcessaEstoque = isAcessaEstoque;
	}
	
	public Boolean isAcessaRH() {
		return isAcessaRH;
	}
	
	public void setIsAcessaRH(Boolean isAcessaRH) {
		this.isAcessaRH = isAcessaRH;
	}
	
	public Boolean isAcessaVendas() {
		return isAcessaVendas;
	}
	
	public void setIsAcessaVendas(Boolean isAcessaVendas) {
		this.isAcessaVendas = isAcessaVendas;
	}
	
	public Transacoes getTransacoes() {
		return transacoes;
	}
	
	public void setTransacoes(Transacoes transacoes) {
		this.transacoes = transacoes;
	}
	
	public void enableAllOptions(){
		this.isAcessaAssistencia = true;
		this.isAcessaComercial = true;
		this.isAcessaEstoque = true;
		this.isAcessaRH = true;
		this.isAcessaVendas = true;
	}
	
	public void enableDefaultOptions(){
		this.isAcessaComercial = true;
	}

}
