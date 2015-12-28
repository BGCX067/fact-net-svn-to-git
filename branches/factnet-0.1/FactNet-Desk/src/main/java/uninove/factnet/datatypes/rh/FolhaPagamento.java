package uninove.factnet.datatypes.rh;

import java.util.Date;

public class FolhaPagamento {

	private Date dataPagamento;
	private boolean isPossuiFGTS;
	private boolean isPossuiMedico;
	private boolean isPossuiVR;
	private boolean isPossuiVT;
	private double valorBruto;
	private double valorComissaoMes;
	private double valorDescontoFGTS;
	private double valorMedico;
	private double valorVr;
	private double valorVt;
	private double valorLiquido;
	/**
	 * @return the dataPagamento
	 */
	public Date getDataPagamento() {
		return dataPagamento;
	}
	/**
	 * @param dataPagamento the dataPagamento to set
	 */
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	/**
	 * @return the isPossuiFGTS
	 */
	public boolean isPossuiFGTS() {
		return isPossuiFGTS;
	}
	/**
	 * @param isPossuiFGTS the isPossuiFGTS to set
	 */
	public void setPossuiFGTS(boolean isPossuiFGTS) {
		this.isPossuiFGTS = isPossuiFGTS;
	}
	/**
	 * @return the isPossuiMedico
	 */
	public boolean isPossuiMedico() {
		return isPossuiMedico;
	}
	/**
	 * @param isPossuiMedico the isPossuiMedico to set
	 */
	public void setPossuiMedico(boolean isPossuiMedico) {
		this.isPossuiMedico = isPossuiMedico;
	}
	/**
	 * @return the isPossuiVR
	 */
	public boolean isPossuiVR() {
		return isPossuiVR;
	}
	/**
	 * @param isPossuiVR the isPossuiVR to set
	 */
	public void setPossuiVR(boolean isPossuiVR) {
		this.isPossuiVR = isPossuiVR;
	}
	/**
	 * @return the isPossuiVT
	 */
	public boolean isPossuiVT() {
		return isPossuiVT;
	}
	/**
	 * @param isPossuiVT the isPossuiVT to set
	 */
	public void setPossuiVT(boolean isPossuiVT) {
		this.isPossuiVT = isPossuiVT;
	}
	/**
	 * @return the valorBruto
	 */
	public double getValorBruto() {
		return valorBruto;
	}
	/**
	 * @param valorBruto the valorBruto to set
	 */
	public void setValorBruto(double valorBruto) {
		this.valorBruto = valorBruto;
	}
	/**
	 * @return the valorComissaoMes
	 */
	public double getValorComissaoMes() {
		return valorComissaoMes;
	}
	/**
	 * @param valorComissaoMes the valorComissaoMes to set
	 */
	public void setValorComissaoMes(double valorComissaoMes) {
		this.valorComissaoMes = valorComissaoMes;
	}
	/**
	 * @return the valorDescontoFGTS
	 */
	public double getValorDescontoFGTS() {
		return valorDescontoFGTS;
	}
	/**
	 * @param valorDescontoFGTS the valorDescontoFGTS to set
	 */
	public void setValorDescontoFGTS(double valorDescontoFGTS) {
		this.valorDescontoFGTS = valorDescontoFGTS;
	}
	/**
	 * @return the valorMedico
	 */
	public double getValorMedico() {
		return valorMedico;
	}
	/**
	 * @param valorMedico the valorMedico to set
	 */
	public void setValorMedico(double valorMedico) {
		this.valorMedico = valorMedico;
	}
	/**
	 * @return the valorVr
	 */
	public double getValorVr() {
		return valorVr;
	}
	/**
	 * @param valorVr the valorVr to set
	 */
	public void setValorVr(double valorVr) {
		this.valorVr = valorVr;
	}
	/**
	 * @return the valorVt
	 */
	public double getValorVt() {
		return valorVt;
	}
	/**
	 * @param valorVt the valorVt to set
	 */
	public void setValorVt(double valorVt) {
		this.valorVt = valorVt;
	}
	/**
	 * @return the valorLiquido
	 */
	public double getValorLiquido() {
		this.calcularValorLiquido();
		return valorLiquido;
	}
	/**
	 * @param valorLiquido the valorLiquido to set
	 */
	public void setValorLiquido(double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
	private void calcularValorLiquido(){
		if(this.valorBruto != 0.0){
			this.valorLiquido = this.valorBruto - (this.valorDescontoFGTS + this.valorMedico + this.valorVr + this.valorVt);
			this.valorLiquido+=this.valorComissaoMes;
		}
	}
	
}
