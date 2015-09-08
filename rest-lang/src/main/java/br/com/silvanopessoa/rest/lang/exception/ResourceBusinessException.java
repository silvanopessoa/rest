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
 * The Class BusinessException.
 * 
 * Info: http://tools.ietf.org/html/rfc2518#section-10.3
 * Config: exception-handler-config.xml
 * Handler: ResourceBusinessExceptionHandler.java
 * 
 * 10.3 422 Unprocessable Entity
 *
 *  The 422 (Unprocessable Entity) status code means the server
 *  understands the content type of the request entity (hence a
 *  415(Unsupported Media Type) status code is inappropriate), and the
 *  syntax of the request entity is correct (thus a 400 (Bad Request)
 *  status code is inappropriate) but was unable to process the contained
 *  instructions.  For example, this error condition may occur if an XML
 *  request body contains well-formed (i.e., syntactically correct), but
 *  semantically erroneous XML instructions.
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
	 * Instancia um novo(a) resource business exception.
	 *
	 * @param errorMessage O(a)(s) error message
	 */
	public ResourceBusinessException(ErrorMessage errorMessage){
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
