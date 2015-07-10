/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  20/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

/**
 * The Class MessageBundleUtil.
 */
@Component
public class MessageBundleUtil {

    /** O(a)(s) msg. */
    @Autowired
    private ResourceBundleMessageSource msg;
    
    /** A Constante PT_BR. */
    public static final String PT_BR = "pt_BR";
    
	/**
	 * Obtém o valor do(a)(s) message.
	 *
	 * @param code O(a)(s) code
	 * @param args O(a)(s) args
	 * @return O(a)(s) message
	 */
	public final String getMessage(String code, Object[] args){
		return msg.getMessage(code,args,new Locale(PT_BR));
	}
	
	/**
	 * Obtém o valor do(a)(s) message.
	 *
	 * @param code O(a)(s) code
	 * @return O(a)(s) message
	 */
	public final String getMessage(String code){
		return msg.getMessage(code,new Object[] {},new Locale(PT_BR));
	}
}
