/**
 * 
 */
package uninove.factnet.enums;

/**
 * @author cjalmeida
 *
 */
public enum EDepartamento {
	
	RH(1, "RH"),
	TECNICO(2, "Tecnico"),
	COMERCIAL(3, "Comercial"),
	GERENCIAL(4, "Gerencial");
	
	private int id;
	private String nome;
	
	private EDepartamento(int id, String nome) {
		 this.nome = nome;
		 this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	 
	public static EDepartamento parse(int id){
		EDepartamento depto = null;
		switch (id) {
		case 1:
			depto = EDepartamento.RH;
			break;
		case 2:
			depto = EDepartamento.TECNICO;
			break;
		case 3:
			depto = EDepartamento.COMERCIAL;
			break;
		case 4:
			depto = EDepartamento.GERENCIAL;
			break;
		}
		return depto;
	}

}
