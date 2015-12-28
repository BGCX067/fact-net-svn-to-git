/**
 * 
 */
package uninove.factnet.enums;

/**
 * Enum com todos os cargos da loja 
 * @author cjalmeida
 *
 */
public enum ECargo {
	
	ATENDENTE(1,"Atendente"),
	TECNICO_INFO(2, "Tecnico Informatica"),
	GERENTE(3, "Gerente"),
	MOTOBOY(4, "Motoboy"),
	TECNICO_MOTO(5, "Tecnico Motoboy");
	
	private int id;
	private String nome;
	
	private ECargo(int id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public static ECargo parser(int id){
		ECargo cargo = null;
		switch (id) {
		case 1:
			cargo = ECargo.ATENDENTE;
			break;
		case 2:
			cargo = ECargo.TECNICO_INFO;
			break;
		case 3:
			cargo = ECargo.GERENTE;
			break;
		case 4:
			cargo = ECargo.MOTOBOY;
			break;
		case 5:
			cargo = ECargo.TECNICO_MOTO;
			break;
		}
		return cargo;
	}
	

}
