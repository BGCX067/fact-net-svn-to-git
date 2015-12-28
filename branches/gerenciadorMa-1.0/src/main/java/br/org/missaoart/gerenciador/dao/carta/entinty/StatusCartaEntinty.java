package br.org.missaoart.gerenciador.dao.carta.entinty;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statusCarta")
public class StatusCartaEntinty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idStatus", length=10, unique = true, columnDefinition="INT")
	private Long idStatus;
	
	@Column(name="estado", length=20, nullable=false)
	private String nmStatus;
	
	@Column(name="dtEstado", nullable=false)
	private Date dtStatus;
	
	@Column(name="descricao", columnDefinition="TINYTEXT", nullable=false)
	private String descricao;
	
	public StatusCartaEntinty() {}
	
	public StatusCartaEntinty(Long idStatus){
		this.idStatus = idStatus; 
	}
	
	public Long getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}
	public String getNmStatus() {
		return nmStatus;
	}
	public void setNmStatus(String nmStatus) {
		this.nmStatus = nmStatus;
	}
	public Date getDtStatus() {
		return dtStatus;
	}
	public void setDtStatus(Date dtStatus) {
		this.dtStatus = dtStatus;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
