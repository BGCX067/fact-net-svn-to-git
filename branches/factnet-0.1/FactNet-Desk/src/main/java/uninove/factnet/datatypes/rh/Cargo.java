package uninove.factnet.datatypes.rh;

public class Cargo {
	
	private String escolaridadeMinima;
	private Long idCargo;
	private String nomeCargo;
	private Double salarioBase;
	
	public Cargo(){
		
	}
	
	public Cargo(Long idCargo) {
		super();
		this.idCargo = idCargo;
	}
	
	public String getEscolaridadeMinima() {
		return escolaridadeMinima;
	}
	
	public void setEscolaridadeMinima(String escolaridadeMinima) {
		this.escolaridadeMinima = escolaridadeMinima;
	}
	
	public Long getIdCargo() {
		return idCargo;
	}
	
	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}
	
	public String getNomeCargo() {
		return nomeCargo;
	}
	
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	
	public Double getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	@Override
	public String toString() {
		return this.nomeCargo;
	}
}
