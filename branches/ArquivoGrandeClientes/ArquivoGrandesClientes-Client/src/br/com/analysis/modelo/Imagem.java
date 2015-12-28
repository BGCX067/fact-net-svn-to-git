package br.com.analysis.modelo;

public class Imagem {
	
	String 	tpRegistro,
			codImagemTopo,
			codImagemRodape;

	public Imagem() {
		super();
	}

	public Imagem(String tpRegistro, String codImagemTopo,
			String codImagemRodape)throws Exception {
		super();
		this.setTpRegistro(tpRegistro);
		this.setCodImagemTopo(codImagemTopo);
		this.setCodImagemRodape(codImagemRodape);
	}

	public String getTpRegistro() {
		return tpRegistro;
	}

	public void setTpRegistro(String tpRegistro) {
		this.tpRegistro = tpRegistro;
	}

	public String getCodImagemTopo() {
		return codImagemTopo;
	}

	public void setCodImagemTopo(String codImagemTopo) {
		this.codImagemTopo = codImagemTopo;
	}

	public String getCodImagemRodape() {
		return codImagemRodape;
	}

	public void setCodImagemRodape(String codImagemRodape) {
		this.codImagemRodape = codImagemRodape;
	}

	@Override
	public String toString() {
		return "Imagem [tpRegistro=" + tpRegistro + ", codImagemTopo="
				+ codImagemTopo + ", codImagemRodape=" + codImagemRodape + "]";
	}
}
