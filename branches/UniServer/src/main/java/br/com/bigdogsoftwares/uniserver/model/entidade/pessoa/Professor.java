package br.com.bigdogsoftwares.uniserver.model.entidade.pessoa;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Implementa atributos referentes ao professor
 * @author cjalmeida
 * @version 1.0
 * @created 31-jul-2013 16:41:56
 */
@Entity
@Table(name="tbProfessor")
@PrimaryKeyJoinColumn(name="matricula")
public class Professor extends Pessoa {
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}