/**
 * 
 */
package uninove.factnet.exceptions;

/**
 * @author cjalmeida
 *
 */
public class BusinessException extends Exception {
	
	private static final long serialVersionUID = -2662926751061175883L;

	private String message;
	
	private Throwable throwable;
	
	
	
	/**
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
	 * Erros de validação
	 */
	public BusinessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
		this.throwable = cause;
	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);
		this.throwable = cause;
	}
	
	

}
