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
package br.com.silvanopessoa.rest.api.exception.handler;

import static br.com.silvanopessoa.rest.api.type.RFC2518Type.UNPROCESSABLE_ENTITY_SPEC;
import static br.com.silvanopessoa.rest.api.type.RFC2518Type.UNPROCESSABLE_ENTITY_URI;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import br.com.silvanopessoa.rest.api.exception.ResourceBusinessException;
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
	 * Instancia um novo(a) resource not found exception handler.
	 */
	public ResourceBusinessExceptionHandler() {
		super(UNPROCESSABLE_ENTITY);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(ResourceBusinessException ex, HttpServletRequest req) {
        ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
        errorMessage=ex.getErrorMessage();
        if(errorMessage==null){
        	errorMessage = new ErrorMessage();
        }
       	msg.setType(this.getType());
       	msg.setTitle(this.getTitle());
       	msg.setDetail(this.getDetail());
       	msg.setInstance(this.getUriInstance());
        return msg;
    }
	
	/**
	 * Obtém o valor do(a)(s) detail.
	 *
	 * @return O(a)(s) detail
	 */
	private String getDetail(){
        if(errorMessage.getDetail()==null){
        	return HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase();
        }else{
        	return errorMessage.getDetail();
        }
	}
	
	/**
	 * Obtém o valor do(a)(s) title.
	 *
	 * @return O(a)(s) title
	 */
	private String getTitle(){
        if(errorMessage.getTitle()==null){
        	return HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase();
        }else{
        	return errorMessage.getTitle();
        }
	}
	
	/**
	 * Obtém o valor do(a)(s) type.
	 *
	 * @return O(a)(s) type
	 */
	private URI getType(){
		 if(errorMessage.getType()==null){
			try {
				return new URI(UNPROCESSABLE_ENTITY_SPEC);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + UNPROCESSABLE_ENTITY_SPEC, e);
			}
		 }else{
			 return errorMessage.getType();
		 }
		return null;
	}

	/**
	 * Obtém o valor do(a)(s) uri instance.
	 *
	 * @return O(a)(s) uri instance
	 */
	private URI getUriInstance(){
		 if(errorMessage.getInstance()==null){
			try {
				return new URI(UNPROCESSABLE_ENTITY_URI);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + UNPROCESSABLE_ENTITY_URI, e);
			}
		 }else{
			 return errorMessage.getInstance();
		 }
		return null;
	}

}
