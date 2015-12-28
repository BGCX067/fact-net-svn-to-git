package uninove.factnet.datatypes.enums;

public enum EEstadoCivil {
	
	CASADO(1, "Casado"),
	SOLTEIRO(2, "Solteiro");
	
	private int id;
	private String nome;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private EEstadoCivil(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public EEstadoCivil parse(String nome){
		if(nome.equalsIgnoreCase(EEstadoCivil.CASADO.getNome())){
			return EEstadoCivil.CASADO;
		}
		else if(nome.equalsIgnoreCase(EEstadoCivil.SOLTEIRO.getNome())){
			return EEstadoCivil.SOLTEIRO;
		}else{
			return null;
		}
	}

}
