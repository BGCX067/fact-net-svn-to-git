package br.com.bigdogsoftwares.uniserver.admin.form;

import org.apache.struts.action.ActionForm;

public class CursoForm extends ActionForm {

	private static final long serialVersionUID = -540595669805562069L;
	
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
