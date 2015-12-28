/**
 * 
 */
package uninove.factnet.enums;

/**
 * Enum representante do meio de inclusão do cliente no sistema ( WEB/ LOJA/ E-Commerce)
 * @author cjalmeida
 *
 */
public enum EMeioInclusao {
	
	LOJA(1, "Loja Fisica"),
	WEB(2, "WEB Interno"),
	ECOMMERCE(3, "E-Commerce");
	
	private int id;
	private String nome;
	
	private EMeioInclusao(int id, String nome) {
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
	
	public static EMeioInclusao parser(int id){
		EMeioInclusao meioInclusao = null;
		switch (id) {
			case 1:
				meioInclusao = EMeioInclusao.LOJA;
				break;
			case 2:
				meioInclusao = EMeioInclusao.WEB;
				break;
			default:
				meioInclusao = EMeioInclusao.ECOMMERCE;
				break;
		}
		
		return meioInclusao;
	}

}
