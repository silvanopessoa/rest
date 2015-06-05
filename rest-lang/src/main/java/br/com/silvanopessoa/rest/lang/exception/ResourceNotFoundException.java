/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  18/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.exception;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class ResourceNotFoundException.
 */
public class ResourceNotFoundException extends RuntimeException{

	/** A Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** O(a)(s) error message. */
	private ErrorMessage errorMessage;
	
	/**
	 * Instancia um novo(a) resource not found exception.
	 */
	public ResourceNotFoundException() {
		super();
	}

	/**
	 * Instancia um novo(a) resource not found exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 * @param enableSuppression O(a)(s) enable suppression
	 * @param writableStackTrace O(a)(s) writable stack trace
	 */
	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instancia um novo(a) resource not found exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia um novo(a) resource not found exception.
	 *
	 * @param message O(a)(s) message
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Instancia um novo(a) resource not found exception.
	 *
	 * @param cause O(a)(s) cause
	 */
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Instancia um novo(a) resource not found exception.
	 *
	 * @param errorMessage O(a)(s) error message
	 */
	public ResourceNotFoundException(ErrorMessage errorMessage){
		this.errorMessage = errorMessage;
	}

	/**
	 * Obtém o valor do(a)(s) error message.
	 *
	 * @return O(a)(s) error message
	 */
	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

}
