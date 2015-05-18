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
package br.com.silvanopessoa.rest.api.exception;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class BusinessException.
 * 
 * Info: http://www.restpatterns.org/HTTP_Status_Codes/422_-_Unprocessable_Entity
 * Config: exception-handler-config.xml
 * Handler: ResourceBusinessExceptionHandler.java
 * 
 */
public class ResourceBusinessException extends RuntimeException{

	/** A Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** O(a)(s) error message. */
	private ErrorMessage errorMessage;
	
	/**
	 * Instancia um novo(a) business exception.
	 */
	public ResourceBusinessException() {
		super();
	}

	/**
	 * Instancia um novo(a) business exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 * @param enableSuppression O(a)(s) enable suppression
	 * @param writableStackTrace O(a)(s) writable stack trace
	 */
	public ResourceBusinessException(String message, Throwable cause,boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instancia um novo(a) business exception.
	 *
	 * @param message O(a)(s) message
	 * @param cause O(a)(s) cause
	 */
	public ResourceBusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia um novo(a) business exception.
	 *
	 * @param message O(a)(s) message
	 */
	public ResourceBusinessException(String message) {
		super(message);
	}

	/**
	 * Instancia um novo(a) business exception.
	 *
	 * @param cause O(a)(s) cause
	 */
	public ResourceBusinessException(Throwable cause) {
		super(cause);
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
