/**
 * 
 */
package uninove.factnet.dtos;

/**
 * Contem todas as permissoes que determinada pessoa possuir.
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public class PermissaoVO {
	
	private Integer idCliente;
	private boolean acessarComercial;
	private boolean acessarAdminstracao;
	private boolean acessarRH;
	private boolean acessarEstoque;
	private boolean acessarCMS;
	private boolean acessarRelatorios;
	private boolean acessarFaturas;
	
	public PermissaoVO() {
		
		this.acessarComercial = true;
		
		this.acessarAdminstracao = false;
		this.acessarCMS = false;
		this.acessarEstoque = false;
		this.acessarFaturas = false;
		this.acessarRelatorios = false;
		this.acessarRH = false;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Possui acesso ao Sistema Comercial
	 * @return the acessarComercial
	 */
	public boolean isAcessarComercial() {
		return acessarComercial;
	}
	/**
	 * Alterar acesso ao Sistema Comercial
	 * @param acessarComercial the acessarComercial to set
	 */
	public void setAcessarComercial(boolean acessarComercial) {
		this.acessarComercial = acessarComercial;
	}
	/**
	 * Possui acesso ao Sistema Adminstração
	 * @return the acessarAdminstracao
	 */
	public boolean isAcessarAdminstracao() {
		return acessarAdminstracao;
	}
	/**
	 * Alterar acesso ao Sistema Adminstracao
	 * @param acessarAdminstracao the acessarAdminstracao to set
	 */
	public void setAcessarAdminstracao(boolean acessarAdminstracao) {
		this.acessarAdminstracao = acessarAdminstracao;
	}
	/**
	 * Possui acesso ao Sistema RH
	 * @return the acessarRH
	 */
	public boolean isAcessarRH() {
		return acessarRH;
	}
	/**
	 * Alterar acesso ao Sistema RH
	 * @param acessarRH the acessarRH to set
	 */
	public void setAcessarRH(boolean acessarRH) {
		this.acessarRH = acessarRH;
	}
	/**
	 * Possui acesso ao Sistema Estoque
	 * @return the acessarEstoque
	 */
	public boolean isAcessarEstoque() {
		return acessarEstoque;
	}
	/**
	 * Alterar acesso ao Sistema Estoque
	 * @param acessarEstoque the acessarEstoque to set
	 */
	public void setAcessarEstoque(boolean acessarEstoque) {
		this.acessarEstoque = acessarEstoque;
	}
	/**
	 * Possui acesso ao Sistema CMS (Gerenciamento do Site)
	 * @return the acessarCMS
	 */
	public boolean isAcessarCMS() {
		return acessarCMS;
	}
	/**
	 * Alterar acesso ao Sistema CMS
	 * @param acessarCMS the acessarCMS to set
	 */
	public void setAcessarCMS(boolean acessarCMS) {
		this.acessarCMS = acessarCMS;
	}
	/**
	 * Possui acesso ao Sistema Relatorios
	 * @return the acessarRelatorios
	 */
	public boolean isAcessarRelatorios() {
		return acessarRelatorios;
	}
	/**
	 * Alterar acesso ao Sistema Relatorios
	 * @param acessarRelatorios the acessarRelatorios to set
	 */
	public void setAcessarRelatorios(boolean acessarRelatorios) {
		this.acessarRelatorios = acessarRelatorios;
	}
	/**
	 * Possui acesso ao Sistema Faturas (entrada e saida de caixa da empresa)
	 * @return the acessarFaturas
	 */
	public boolean isAcessarFaturas() {
		return acessarFaturas;
	}
	/**
	 * Alterar acesso ao Sistema Faturas
	 * @param acessarFaturas the acessarFaturas to set
	 */
	public void setAcessarFaturas(boolean acessarFaturas) {
		this.acessarFaturas = acessarFaturas;
	}
	
	

}
