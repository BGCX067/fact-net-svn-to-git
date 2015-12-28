package br.com.bigdogsoftwares.uniserver.model.entidade.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * @author Cristiano
 * @version 1.0
 * @created 10-ago-2013 13:45:27
 */
@Entity
@Table(name="tbPermissoes")
public class Permissoes {

	@Id
	@GenericGenerator(name="auto", strategy="increment")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="auto")
	@Column(name="id", nullable=false, updatable=false)
	private Long id;
	
	@Column(name="acessEdit", insertable=true, updatable=true)
	private boolean edit;
	
	@Column(name="acessReport", insertable=true, updatable=true)
	private boolean report;
	
	@Column(name="acessVisualize", insertable=true, updatable=true)
	private boolean visualize;

	public Permissoes(){

	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	public boolean isVisualize() {
		return visualize;
	}

	public void setVisualize(boolean visualize) {
		this.visualize = visualize;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissoes other = (Permissoes) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}