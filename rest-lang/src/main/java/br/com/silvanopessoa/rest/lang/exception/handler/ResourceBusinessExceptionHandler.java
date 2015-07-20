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

import static br.com.silvanopessoa.rest.lang.type.RFC2518Type.UNPROCESSABLE_ENTITY_SPEC;
import static br.com.silvanopessoa.rest.lang.type.RFC2518Type.UNPROCESSABLE_ENTITY_URI;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import br.com.silvanopessoa.rest.lang.exception.ResourceBusinessException;
import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

/**
 * The Class BusinessExceptionHandler.
 */
public class ResourceBusinessExceptionHandler extends ErrorMessageRestExceptionHandler<ResourceBusinessException>{

	/** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceBusinessExceptionHandler.class);

    /** O(a)(s) error message. */
    private ErrorMessage errorMessage;
    
	/**
	 * Instancia um novo(a) resource business exception handler.
	 */
	public ResourceBusinessExceptionHandler() {
		super(UNPROCESSABLE_ENTITY);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(ResourceBusinessException ex, HttpServletRequest req) {
		LOGGER.debug("ResourceBusinessExceptionHandler - Iniciado");
        ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
        errorMessage=ex.getErrorMessage();
        if(errorMessage==null){
        	errorMessage = new ErrorMessage();
        }
       	msg.setType(ResourceHandlerUtil.getType(errorMessage,UNPROCESSABLE_ENTITY_SPEC));
       	msg.setTitle(ResourceHandlerUtil.getTitle(errorMessage,HttpStatus.UNPROCESSABLE_ENTITY));
       	msg.setDetail(ResourceHandlerUtil.getDetail(errorMessage,HttpStatus.UNPROCESSABLE_ENTITY));
       	msg.setInstance(ResourceHandlerUtil.getUriInstance(errorMessage,UNPROCESSABLE_ENTITY_URI));
       	LOGGER.debug("ResourceBusinessExceptionHandler - Concluído");
        return msg;
    }

}
