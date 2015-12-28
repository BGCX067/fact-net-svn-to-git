package uninove.factnet.datatypes.rh;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	private Long idDepartamento;
	private List<Funcionario> integrantes = new ArrayList<Funcionario>();
	private String nomeDepartamento;
	private Funcionario responsavel;
	/**
	 * @return the idDepartamento
	 */
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	/**
	 * @return the integrantes
	 */
	public List<Funcionario> getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<Funcionario> integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * @return the nomeDepartamento
	 */
	public String getNomeDepartamento() {
		return nomeDepartamento;
	}
	/**
	 * @param nomeDepartamento the nomeDepartamento to set
	 */
	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}
	/**
	 * @return the responsavel
	 */
	public Funcionario getResponsavel() {
		return responsavel;
	}
	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(Funcionario responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override
	public String toString() {
		return this.nomeDepartamento;
	}
}
