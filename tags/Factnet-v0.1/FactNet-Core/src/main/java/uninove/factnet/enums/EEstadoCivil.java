/**
 * 
 */
package uninove.factnet.enums;

/**
 * @author cjalmeida
 *
 */
public enum EEstadoCivil {
	
	SOLTEIRO(1, "Solteiro"),
	CASADO(2, "Casado");
	
	private int id;
	private String nome;
	
	private EEstadoCivil(int id, String nome) {
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
	
	public static EEstadoCivil parse(int id){
		return EEstadoCivil.CASADO.id == id ? EEstadoCivil.CASADO : EEstadoCivil.SOLTEIRO;
	}

}
