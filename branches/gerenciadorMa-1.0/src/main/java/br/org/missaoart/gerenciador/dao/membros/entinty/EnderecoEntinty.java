package br.org.missaoart.gerenciador.dao.membros.entinty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class EnderecoEntinty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idEndereco", length=10, unique = true, columnDefinition="INT")
	private Long idEndereco;
	
	@Column(name="logradouro", nullable=false, length=50)
	private String logradouro;
	
	@Column(name="bairro", nullable=false, length=50)
	private String bairro;
	
	@Column(name="cidade", nullable=false, length=50)
	private String cidade;
	
	@Column(name="estado", nullable=false, length=50)
	private String estado;
	
	@Column(name="nuResidencia", nullable=false, columnDefinition="INT", length=5)
	private Integer nuResidencia;
	
	@Column(name="complemento", nullable=true, length=20)
	private String complemento;
	
	@Column(name="cep", nullable=false, length=9)
	private String cep;
	
	@Column(name="latitude", nullable=false)
	private Double latitude;
	
	@Column(name="longitude", nullable=false)
	private Double longitude;
	
	
	public EnderecoEntinty(){}
	
	public EnderecoEntinty(Long idEndereco){
		this.idEndereco = idEndereco;
	}
	
	
	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getNuResidencia() {
		return nuResidencia;
	}
	public void setNuResidencia(Integer nuResidencia) {
		this.nuResidencia = nuResidencia;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
