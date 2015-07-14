package br.com.silvanopessoa.rest.lang.exception.handler;

import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.UNSUPPORTED_MEDIA_TYPE_SPEC;
import static br.com.silvanopessoa.rest.lang.type.RFC2616Type.UNSUPPORTED_MEDIA_TYPE_URI;
import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;

import cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;
import cz.jirutka.spring.exhandler.messages.ValidationErrorMessage;

public class ResourceInvalidMediaTypeHandler extends ErrorMessageRestExceptionHandler<InvalidMediaTypeException>{

	/** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceInvalidMediaTypeHandler.class);

    /** O(a)(s) error message. */
    private ErrorMessage errorMessage;
    
	public ResourceInvalidMediaTypeHandler() {
		super(UNSUPPORTED_MEDIA_TYPE);
	}

	/* (non-Javadoc)
	 * @see cz.jirutka.spring.exhandler.handlers.ErrorMessageRestExceptionHandler#createBody(java.lang.Exception, javax.servlet.http.HttpServletRequest)
	 */
	@Override
    public ErrorMessage createBody(InvalidMediaTypeException ex, HttpServletRequest req) {
        ErrorMessage tmpl = super.createBody(ex, req);
        ValidationErrorMessage msg = new ValidationErrorMessage(tmpl);
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
        	return HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase();
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
        	return HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase();
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
				return new URI(UNSUPPORTED_MEDIA_TYPE_SPEC);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + UNSUPPORTED_MEDIA_TYPE_SPEC, e);
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
				return new URI(UNSUPPORTED_MEDIA_TYPE_URI);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + UNSUPPORTED_MEDIA_TYPE_URI, e);
			}
		 }else{
			 return errorMessage.getInstance();
		 }
		return null;
	}
}
