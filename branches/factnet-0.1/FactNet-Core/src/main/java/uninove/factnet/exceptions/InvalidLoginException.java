/**
 * 
 */
package uninove.factnet.exceptions;

/**
 * Exception de validação de login
 * @author cjalmeida
 * @since 0.1
 * @version 1.0
 */
public class InvalidLoginException extends Exception {
	
	private static final long serialVersionUID = 5301260626800143575L;
	
	private Throwable throwable;
	private String message;
	
	public InvalidLoginException() {
		super();
	}
	
	public InvalidLoginException(String message) {
		super(message);
		this.message = message;
	}
	
	public InvalidLoginException(Throwable throwable){
		super(throwable);
		this.throwable = throwable;
	}
	
	public InvalidLoginException(String message, Throwable throwable){
		super(message, throwable);
		this.message = message;
		this.throwable = throwable;
	}

	/**
	 * @return the throwable
	 */
	public Throwable getThrowable() {
		return throwable;
	}

	/**
	 * @param throwable the throwable to set
	 */
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	/**
	 * Retorna mensagem de erro
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
