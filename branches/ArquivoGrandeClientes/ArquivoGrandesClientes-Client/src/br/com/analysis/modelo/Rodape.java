package br.com.analysis.modelo;

public class Rodape {

	String 	indentificadorLinhaRodape, 
			numRegistro, 
			numTelegramas;

	public Rodape() {
		super();
	}

	public Rodape(String indentificadorLinhaRodape, String numRegistro,
			String numTelegramas) throws Exception {
		super();
		this.setIndentificadorLinhaRodape(indentificadorLinhaRodape);
		this.setNumRegistro(numRegistro);
		this.setNumTelegramas(numTelegramas);
	}

	public String getIndentificadorLinhaRodape() {
		return indentificadorLinhaRodape;
	}

	public void setIndentificadorLinhaRodape(String indentificadorLinhaRodape) {
		this.indentificadorLinhaRodape = indentificadorLinhaRodape;
	}

	public String getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getNumTelegramas() {
		return numTelegramas;
	}

	public void setNumTelegramas(String numTelegramas) {
		this.numTelegramas = numTelegramas;
	}

	@Override
	public String toString() {
		return "Rodape [indentificadorLinhaRodape=" + indentificadorLinhaRodape
				+ ", numRegistro=" + numRegistro + ", numTelegramas="
				+ numTelegramas + "]";
	}

}
