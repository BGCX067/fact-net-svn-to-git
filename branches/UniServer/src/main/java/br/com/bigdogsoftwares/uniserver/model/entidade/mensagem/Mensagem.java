/**
 * 
 */
package br.com.bigdogsoftwares.uniserver.model.entidade.mensagem;

import com.google.gson.Gson;

/**
 * @author jborba
 * 
 */
public class Mensagem {

	private String textoDaMensagem;
	private boolean isError;

	public Mensagem() {
		// TODO Auto-generated constructor stub
	}

	public Mensagem(String textoDaMensagem, boolean isError) {
		this.textoDaMensagem = textoDaMensagem;
		this.isError = isError;
	}

	/**
	 * @return the textoDaMensagem
	 */
	public String getTextoDaMensagem() {
		return textoDaMensagem;
	}

	/**
	 * @param textoDaMensagem
	 *            the textoDaMensagem to set
	 */
	public void setTextoDaMensagem(String textoDaMensagem) {
		this.textoDaMensagem = textoDaMensagem;
	}

	/**
	 * @return the isError
	 */
	public boolean isError() {
		return isError;
	}

	/**
	 * @param isError
	 *            the isError to set
	 */
	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String toJSON() {
		return new Gson().toJson(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mensagem [textoDaMensagem=" + textoDaMensagem + ", isError=" + isError + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isError ? 1231 : 1237);
		result = prime * result + ((textoDaMensagem == null) ? 0 : textoDaMensagem.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensagem other = (Mensagem) obj;
		if (isError != other.isError)
			return false;
		if (textoDaMensagem == null) {
			if (other.textoDaMensagem != null)
				return false;
		} else if (!textoDaMensagem.equals(other.textoDaMensagem))
			return false;
		return true;
	}

}
