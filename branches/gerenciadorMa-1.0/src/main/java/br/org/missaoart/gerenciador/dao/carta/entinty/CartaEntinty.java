package br.org.missaoart.gerenciador.dao.carta.entinty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.org.missaoart.gerenciador.dao.membros.entinty.PessoaEntinty;

@Entity
@Table(name="carta")
public class CartaEntinty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(columnDefinition="INT", length=10, unique=true)
	private Long idCarta;
	
	@Column(length=50, nullable=false)
	private String tpCarta;
	
	@Column(columnDefinition="TINYTEXT", nullable=false)
	private String descricao;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},optional=false)
	@JoinColumn(name="idStatus", nullable = false, columnDefinition = "INT")
	private StatusCartaEntinty statusCarta;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},optional=false)
	@JoinColumn(name="idDestinatario", nullable = false, columnDefinition = "INT")
	private PessoaEntinty destinatario;
	
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},optional=true)
	@JoinColumn(name="idModelo", nullable = true, columnDefinition = "INT")
	private ModeloCartaEntinty modelo;
	
	public Long getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(Long idCarta) {
		this.idCarta = idCarta;
	}
	public String getTpCarta() {
		return tpCarta;
	}
	public void setTpCarta(String tpCarta) {
		this.tpCarta = tpCarta;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public StatusCartaEntinty getStatusCarta() {
		return statusCarta;
	}
	public void setStatusCarta(StatusCartaEntinty statusCarta) {
		this.statusCarta = statusCarta;
	}
	public PessoaEntinty getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(PessoaEntinty destinatario) {
		this.destinatario = destinatario;
	}
	public ModeloCartaEntinty getModelo() {
		return modelo;
	}
	public void setModelo(ModeloCartaEntinty modelo) {
		this.modelo = modelo;
	}
	
	
}
