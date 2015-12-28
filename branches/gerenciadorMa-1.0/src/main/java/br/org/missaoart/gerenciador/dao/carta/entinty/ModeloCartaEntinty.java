package br.org.missaoart.gerenciador.dao.carta.entinty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modelocarta")
public class ModeloCartaEntinty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(columnDefinition="INT", length=10, unique=true)
	private Long idModelo;
	
	@Column(name="nome", length=50, nullable=false)
	private String nmModelo;
	
	@Column(columnDefinition="TINYTEXT", nullable=false)
	private String descricao;
	
	@Column(length=50, nullable=false)
	private String nmArquivo;
	
	public ModeloCartaEntinty() {}
	
	public ModeloCartaEntinty(Long idModelo){
		this.idModelo = idModelo;
	}
	
	public Long getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Long idModelo) {
		this.idModelo = idModelo;
	}
	public String getNmModelo() {
		return nmModelo;
	}
	public void setNmModelo(String nmModelo) {
		this.nmModelo = nmModelo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNmArquivo() {
		return nmArquivo;
	}
	public void setNmArquivo(String nmArquivo) {
		this.nmArquivo = nmArquivo;
	}
	
	
	
}
