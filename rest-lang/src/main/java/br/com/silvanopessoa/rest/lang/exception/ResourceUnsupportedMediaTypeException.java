/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  13/07/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.exception;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class ResourceUnsupportedMediaTypeException.
 */
public class ResourceUnsupportedMediaTypeException extends RuntimeException{

	/** A Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** O(a)(s) error message. */
	private ErrorMessage errorMessage;

	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 */
	public ResourceUnsupportedMediaTypeException() {
		super();
	}

	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 * @param enableSuppression O(a)(s) enable suppression
	 * @param writableStackTrace O(a)(s) writable stack trace
	 */
	public ResourceUnsupportedMediaTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 */
	public ResourceUnsupportedMediaTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 *
	 * @param message O(a)(s) message
	 */
	public ResourceUnsupportedMediaTypeException(String message) {
		super(message);
	}

	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 *
	 * @param cause O(a)(s) cause
	 */
	public ResourceUnsupportedMediaTypeException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Instancia um novo(a) resource unsupported media type exception.
	 *
	 * @param errorMessage O(a)(s) error message
	 */
	public ResourceUnsupportedMediaTypeException(ErrorMessage errorMessage) {
		super(errorMessage.getDetail());
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
