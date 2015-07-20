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
package br.com.silvanopessoa.rest.lang.exception.handler;

import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.NOT_FOUND_SPEC;
import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.NOT_FOUND_URI;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.silvanopessoa.rest.lang.exception.ResourceNotFoundException;
import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

/**
 * O(a) Class ResourceNotFoundException.
 *
 * @author silvano.pessoa
 * @since 04/03/2015 - 21:24:44
 * 
 * https://stormpath.com/blog/spring-mvc-rest-exception-handling-best-practices-part-1
 * https://blog.apigee.com/detail/restful_api_design_what_about_errors
 * <!-- 04 - INTERCEPTADOR DE EXCEPTION -->
 *  
 *  The canonical model for problem details is a JSON [RFC4627] object.
 *
 *  When serialised as a JSON document, that format is identified with
 *  the "application/problem+json" media type.
 *
 *  For example, a HTTP response carrying JSON problem details:
 *
 *  HTTP/1.1 403 Forbidden
 *  Content-Type: application/problem+json
 *  Content-Language: en
 *
 *  {
 *   "type": "http://example.com/probs/out-of-credit",
 *   "title": "You do not have enough credit.",
 *   "detail": "Your current balance is 30, but that costs 50.",
 *   "instance": "http://example.net/account/12345/msgs/abc",
 *   "balance": 30,
 *   "accounts": ["http://example.net/account/12345",
 *                "http://example.net/account/67890"]
 *  }
 *
 *  Here, the out-of-credit problem (identified by its type URI)
 *  indicates the reason for the 403 in "title", gives a reference for
 *  the specific problem occurrence with "instance", gives occurrence-
 *  specific details in "detail", and adds two extensions; "balance"
 *  conveys the account's balance, and "accounts" gives links where the
 *  account can be topped up.
 *
 */
public class ResourceNotFoundExceptionHandler extends ErrorMessageRestExceptionHandler<ResourceNotFoundException> {

    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceNotFoundExceptionHandler.class);

    /** O(a)(s) error message. */
    private ErrorMessage errorMessage;
    
	/**
	 * Instancia um novo(a) resource not found exception handler.
	 */
	public ResourceNotFoundExceptionHandler() {
		super(NOT_FOUND);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(ResourceNotFoundException ex, HttpServletRequest req) {
		LOGGER.debug("ResourceNotFoundExceptionHandler - Iniciado");
        ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
        errorMessage=ex.getErrorMessage();
        if(errorMessage==null){
        	errorMessage = new ErrorMessage();
        }
       	msg.setType(ResourceHandlerUtil.getType(errorMessage,NOT_FOUND_SPEC));
       	msg.setTitle(ResourceHandlerUtil.getTitle(errorMessage,NOT_FOUND));
       	msg.setDetail(ResourceHandlerUtil.getDetail(errorMessage,NOT_FOUND));
       	msg.setInstance(ResourceHandlerUtil.getUriInstance(errorMessage,NOT_FOUND_URI));
       	LOGGER.debug("ResourceNotFoundExceptionHandler - Concluído");
        return msg;
    }
}
