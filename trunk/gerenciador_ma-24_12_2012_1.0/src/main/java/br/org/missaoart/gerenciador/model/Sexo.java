package br.org.missaoart.gerenciador.model;

public enum Sexo {
	
	MASCULINO("Masculino", 'M', 1),
	FEMININO("Feminino", 'F', 2);
	
	private String nmSexo;
	private int idSexo;
	private char slSexo;
	
	private Sexo(String nome, char sigla, int id){
		this.idSexo = id;
		this.slSexo = sigla;
		this.nmSexo = nome;
	}
	
	public String getNmSexo() {
		return nmSexo;
	}

	public void setNmSexo(String nmSexo) {
		this.nmSexo = nmSexo;
	}

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public char getSlSexo() {
		return slSexo;
	}

	public void setSlSexo(char slSexo) {
		this.slSexo = slSexo;
	}

	public Sexo parse(char sigla){
		Sexo sexo = null;
		switch (sigla) {
		case 'M':
			sexo = Sexo.MASCULINO;
			break;
		case 'F':
			sexo = Sexo.FEMININO;
		default:
			break;
		}
		
		return sexo;
	}

}
