package br.com.bigdogsoftwares.uniserver.model.util;

/**
 * @author Cristiano
 * @version 1.0
 * @created 15-ago-2013 12:45:42
 */
public enum EDiaSemana {

	SEGUNDA(0),
	TERCA(1),
	QUARTA(2),
	QUINTA(3),
	SEXTA(4),
	SABADO(5),
	DOMINGO(6);

	private int value;
	
	private EDiaSemana(int value){
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int codDia) {
		this.value = codDia;
	}
	
	

}