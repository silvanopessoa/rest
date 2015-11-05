/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  05/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.exception.handler;

import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.FORBIDDEN_SPEC;
import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.FORBIDDEN_URI;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;

import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

/**
 * The Class ResourceAccessDeniedExceptionHandler.
 */
public class ResourceAccessDeniedExceptionHandler extends ErrorMessageRestExceptionHandler<AccessDeniedException>{

	/** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceAccessDeniedExceptionHandler.class);

    /** O(a)(s) error message. */
    private ErrorMessage errorMessage;
    
	/**
	 * Instancia um novo(a) resource invalid mime type handler.
	 */
	public ResourceAccessDeniedExceptionHandler() {
		super(FORBIDDEN);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(AccessDeniedException ex, HttpServletRequest req) {
		LOGGER.debug("ResourceAccessDeniedExceptionHandler - Iniciado");
        ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
        if(errorMessage==null){
        	errorMessage = new ErrorMessage();
        }
       	msg.setType(ResourceHandlerUtil.getType(errorMessage,FORBIDDEN_SPEC));
       	msg.setTitle(ResourceHandlerUtil.getTitle(errorMessage,FORBIDDEN));
       	msg.setDetail(ResourceHandlerUtil.getDetail(errorMessage,FORBIDDEN));
       	msg.setInstance(ResourceHandlerUtil.getUriInstance(errorMessage,FORBIDDEN_URI));
       	LOGGER.debug("ResourceAccessDeniedExceptionHandler - Concluído");
        return msg;
    }
}
