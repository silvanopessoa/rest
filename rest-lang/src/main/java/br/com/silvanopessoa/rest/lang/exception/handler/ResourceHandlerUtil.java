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

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class ResourceHandlerUtil.
 */
public final class ResourceHandlerUtil {

	/** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceHandlerUtil.class);
    
	/**
	 * Instancia um novo(a) resource handler util.
	 */
	private ResourceHandlerUtil() {
	}
	
	/**
	 * Obtém o valor do(a)(s) detail.
	 *
	 * @param errorMessage O(a)(s) error message
	 * @param status O(a)(s) status
	 * @return O(a)(s) detail
	 */
	public static String getDetail(ErrorMessage errorMessage, HttpStatus status){
        if(errorMessage.getDetail()==null){
        	return status.getReasonPhrase();
        }else{
        	return errorMessage.getDetail();
        }
	}
	
	/**
	 * Obtém o valor do(a)(s) title.
	 *
	 * @param errorMessage O(a)(s) error message
	 * @param status O(a)(s) status
	 * @return O(a)(s) title
	 */
	public static String getTitle(ErrorMessage errorMessage, HttpStatus status){
        if(errorMessage.getTitle()==null){
        	return status.getReasonPhrase();
        }else{
        	return errorMessage.getTitle();
        }
	}
	
	/**
	 * Obtém o valor do(a)(s) type.
	 *
	 * @param errorMessage O(a)(s) error message
	 * @param spec O(a)(s) spec
	 * @return O(a)(s) type
	 */
	public static URI getType(ErrorMessage errorMessage, String spec){
		 if(errorMessage.getType()==null){
			try {
				return new URI(spec);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + spec, e);
			}
		 }else{
			 return errorMessage.getType();
		 }
		return null;
	}

	/**
	 * Obtém o valor do(a)(s) uri instance.
	 *
	 * @param errorMessage O(a)(s) error message
	 * @param spec O(a)(s) spec
	 * @return O(a)(s) uri instance
	 */
	public static URI getUriInstance(ErrorMessage errorMessage, String spec){
		 if(errorMessage.getInstance()==null){
			try {
				return new URI(spec);
			} catch (URISyntaxException e) {
				LOGGER.error("Erro ao criar URI " + spec, e);
			}
		 }else{
			 return errorMessage.getInstance();
		 }
		return null;
	}

}
