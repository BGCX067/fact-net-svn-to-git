package uninove.factnet.datatypes.rh;

import java.util.Date;

public class Comissao {
	
	private Date dataVenda;
	private float valorComissao;
	private float valorVenda;
	/**
	 * @return the dataVenda
	 */
	public Date getDataVenda() {
		return dataVenda;
	}
	/**
	 * @param dataVenda the dataVenda to set
	 */
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	/**
	 * @return the valorComissao
	 */
	public float getValorComissao() {
		return valorComissao;
	}
	/**
	 * @param valorComissao the valorComissao to set
	 */
	public void setValorComissao(float valorComissao) {
		this.valorComissao = valorComissao;
	}
	/**
	 * @return the valorVenda
	 */
	public float getValorVenda() {
		return valorVenda;
	}
	/**
	 * @param valorVenda the valorVenda to set
	 */
	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
}
