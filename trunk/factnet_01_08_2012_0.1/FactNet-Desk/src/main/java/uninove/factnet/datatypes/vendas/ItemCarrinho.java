package uninove.factnet.datatypes.vendas;

public class ItemCarrinho {
	
	private String nomeProduto;
	private Long idProduto;
	private String descricao;
	private Double valorVenda;
	private Boolean isRemover;
	
	/**
	 * @return the nomeProduto
	 */
	public String getNomeProduto() {
		return nomeProduto;
	}
	/**
	 * @param nomeProduto the nomeProduto to set
	 */
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	/**
	 * @return the idProduto
	 */
	public Long getIdProduto() {
		return idProduto;
	}
	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the valorVenda
	 */
	public Double getValorVenda() {
		return valorVenda;
	}
	/**
	 * @param valorVenda the valorVenda to set
	 */
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	/**
	 * @return the isRemover
	 */
	public Boolean getIsRemover() {
		return isRemover;
	}
	/**
	 * @param isRemover the isRemover to set
	 */
	public void setIsRemover(Boolean isRemover) {
		this.isRemover = isRemover;
	}
	
	public ItemCarrinho clonar(){
		ItemCarrinho novoItem = new ItemCarrinho();
		novoItem.setDescricao(this.descricao);
		novoItem.setIdProduto(new Long(this.idProduto));
		novoItem.setIsRemover(this.isRemover);
		novoItem.setNomeProduto(this.nomeProduto);
		novoItem.setValorVenda(new Double(this.valorVenda));
		
		return novoItem;
		
	}

}
