/**
 * 
 */
package uninove.factnet.enums;

/**
 * Representa os tipos de entidade Pessoa possivel no sistema 
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 *
 */
public enum ETipoPessoa {
	
	CLIENTE(1, 'C', "Cliente"),
	FUNCIONARIO(2, 'F', "Funcionario"); 
	
	
	private int id;
	private char sigla;
	private String nomeTipo;
	
	private ETipoPessoa(int id, char sigla, String nomeTipo){
		this.id = id;
		this.sigla = sigla;
		this.nomeTipo = nomeTipo;
	}

	/**
	 * Retorna ID do Tipo
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retorna Sigla do Tipo
	 * @return the sigla
	 */
	public char getSigla() {
		return sigla;
	}

	/**
	 * Retorna Nome do Tipo
	 * @return the nomeTipo
	 */
	public String getNomeTipo() {
		return nomeTipo;
	}
	
	public static ETipoPessoa parse(int id){
		ETipoPessoa tipoPessoa;
		switch (id) {
		case 1:
			tipoPessoa = ETipoPessoa.CLIENTE;
			break;
		case 2:
			tipoPessoa = ETipoPessoa.FUNCIONARIO;
		default:
			tipoPessoa = ETipoPessoa.CLIENTE;
			break;
		}
		return tipoPessoa;
	}
	
}
