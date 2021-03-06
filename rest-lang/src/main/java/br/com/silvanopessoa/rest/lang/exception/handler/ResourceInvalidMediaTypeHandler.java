/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  17/07/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.exception.handler;

import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.UNSUPPORTED_MEDIA_TYPE_SPEC;
import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.UNSUPPORTED_MEDIA_TYPE_URI;
import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.InvalidMediaTypeException;

import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

/**
 * The Class ResourceInvalidMediaTypeHandler.
 */
public class ResourceInvalidMediaTypeHandler extends ErrorMessageRestExceptionHandler<InvalidMediaTypeException>{

	/** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceInvalidMediaTypeHandler.class);

    /** O(a)(s) error message. */
    private ErrorMessage errorMessage;
    
	/**
	 * Instancia um novo(a) resource invalid media type handler.
	 */
	public ResourceInvalidMediaTypeHandler() {
		super(UNSUPPORTED_MEDIA_TYPE);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(InvalidMediaTypeException ex, HttpServletRequest req) {
		LOGGER.debug("ResourceInvalidMediaTypeHandler - Iniciado");
		ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
        if(errorMessage==null){
        	errorMessage = new ErrorMessage();
        }
       	msg.setType(ResourceHandlerUtil.getType(errorMessage,UNSUPPORTED_MEDIA_TYPE_SPEC));
       	msg.setTitle(ResourceHandlerUtil.getTitle(errorMessage,UNSUPPORTED_MEDIA_TYPE));
       	msg.setDetail(ResourceHandlerUtil.getDetail(errorMessage,UNSUPPORTED_MEDIA_TYPE));
       	msg.setInstance(ResourceHandlerUtil.getUriInstance(errorMessage,UNSUPPORTED_MEDIA_TYPE_URI));
       	LOGGER.debug("ResourceInvalidMediaTypeHandler - Concluído");
        return msg;
    }
}
