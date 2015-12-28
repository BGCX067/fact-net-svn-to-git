/**
 * 
 */
package uninove.factnet.enums;

/**
 * Enum para especificar sexo de clientes e funcionarios
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public enum ESexo {
	
	MASCULINO(1,'M', "Masculino"),
	FEMININO(2,'F',"Feminino");
	
	private int id;
	private char sigla;
	private String nome;
	
	private ESexo(int id, char sigla, String nome) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the sigla
	 */
	public char getSigla() {
		return sigla;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	
	public static ESexo parser(char sigla){
		return sigla == 'F' ? ESexo.FEMININO : ESexo.MASCULINO;
	}
	
	
}
