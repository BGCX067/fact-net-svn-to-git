/**
 * 
 */
package uninove.factnet.comercial.rh.dtos;

import java.util.Date;

import uninove.factnet.dtos.PermissaoVO;
import uninove.factnet.dtos.PessoaDTO;
import uninove.factnet.enums.ECargo;
import uninove.factnet.enums.EDepartamento;
import uninove.factnet.enums.EEstadoCivil;
import uninove.factnet.enums.EMeioInclusao;
import uninove.factnet.enums.ESexo;

/**
 * Classe POJO com os atributos existentes em um cadastro de cliente (WEB e DESK) 
 * @author cjalmeida
 *
 */
public class CadastroClienteDTO {

	private Integer id;
	private PermissaoVO permissao;
	private PessoaDTO pessoa;
	private Date dataNasc;
	private ESexo sexo;
	
	//Contato
	private String pais;
	private String cidade;
	private String endereco;
	private Long telefone;
	private String cep;
	
	private EMeioInclusao meioInclusao;
	private Date dataInclusao;
	private Integer idFuncionario;
	
	//Funcionario
	private Date dtAdmissao;
	private Date dtDemissao;
	private Float salario;
	private ECargo cargo;
	private EDepartamento departamento;
	private Boolean flAtivo;
	private EEstadoCivil estadoCivil;
	private Long nuRg;
	private Long nuCpf;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the permissao
	 */
	public PermissaoVO getPermissao() {
		return permissao;
	}
	/**
	 * @param permissao the permissao to set
	 */
	public void setPermissao(PermissaoVO permissao) {
		this.permissao = permissao;
	}
	/**
	 * @return the pessoa
	 */
	public PessoaDTO getPessoa() {
		return pessoa;
	}
	/**
	 * @param pessoa the pessoa to set
	 */
	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
	/**
	 * @return the dataNasc
	 */
	public Date getDataNasc() {
		return dataNasc;
	}
	/**
	 * @param dataNasc the dataNasc to set
	 */
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	/**
	 * @return the sexo
	 */
	public ESexo getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(ESexo sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return the telefone
	 */
	public Long getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return the meioInclusao
	 */
	public EMeioInclusao getMeioInclusao() {
		return meioInclusao;
	}
	/**
	 * @param meioInclusao the meioInclusao to set
	 */
	public void setMeioInclusao(EMeioInclusao meioInclusao) {
		this.meioInclusao = meioInclusao;
	}
	/**
	 * @return the dataInclusao
	 */
	public Date getDataInclusao() {
		return dataInclusao;
	}
	/**
	 * @param dataInclusao the dataInclusao to set
	 */
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	/**
	 * @return the idFuncionario
	 */
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	/**
	 * @param idFuncionario the idFuncionario to set
	 */
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	/**
	 * @return the dtAdmissao
	 */
	public Date getDtAdmissao() {
		return dtAdmissao;
	}
	/**
	 * @param dtAdmissao the dtAdmissao to set
	 */
	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}
	/**
	 * @return the dtDemissao
	 */
	public Date getDtDemissao() {
		return dtDemissao;
	}
	/**
	 * @param dtDemissao the dtDemissao to set
	 */
	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}
	/**
	 * @return the salario
	 */
	public Float getSalario() {
		return salario;
	}
	/**
	 * @param salario the salario to set
	 */
	public void setSalario(Float salario) {
		this.salario = salario;
	}
	/**
	 * @return the cargo
	 */
	public ECargo getCargo() {
		return cargo;
	}
	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(ECargo cargo) {
		this.cargo = cargo;
	}
	/**
	 * @return the departamento
	 */
	public EDepartamento getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(EDepartamento departamento) {
		this.departamento = departamento;
	}
	/**
	 * @return the flAtivo
	 */
	public Boolean getFlAtivo() {
		return flAtivo;
	}
	/**
	 * @param flAtivo the flAtivo to set
	 */
	public void setFlAtivo(Boolean flAtivo) {
		this.flAtivo = flAtivo;
	}
	/**
	 * @return the estadoCivil
	 */
	public EEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(EEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	/**
	 * @return the nuRg
	 */
	public Long getNuRg() {
		return nuRg;
	}
	/**
	 * @param nuRg the nuRg to set
	 */
	public void setNuRg(Long nuRg) {
		this.nuRg = nuRg;
	}
	/**
	 * @return the nuCpf
	 */
	public Long getNuCpf() {
		return nuCpf;
	}
	/**
	 * @param nuCpf the nuCpf to set
	 */
	public void setNuCpf(Long nuCpf) {
		this.nuCpf = nuCpf;
	}
	
	
	
}
