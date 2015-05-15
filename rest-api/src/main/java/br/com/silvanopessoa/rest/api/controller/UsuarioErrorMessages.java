/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  14/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * A classe UsuarioErrorMessages é responsável por gerar mensagens de erros.
 */
@Component
public class UsuarioErrorMessages {

    @Autowired
    private ResourceBundleMessageSource msg;
    
    /** A Constante PT_BR. */
    public static final String PT_BR = "pt_BR";
	/**
	 * Delete check not found message.
	 *
	 * @param login O(a)(s) login
	 * @return O(a)(s) error message
	 */
	public ErrorMessage deleteCheckNotFoundMessage(String login){
	    ErrorMessage message = new ErrorMessage();
	    message.setType(null);
	    message.setTitle(msg.getMessage("error_message_usuario_title_delete_check_not_found_type",new Object[] {},new Locale(PT_BR)));
	    message.setDetail(msg.getMessage("error_message_usuario_title_delete_check_not_found_detail",new Object[] {},new Locale(PT_BR))+login);
	    message.setInstance(linkTo(methodOn(UsuarioController.class).getUsuario(login, null)).toUri());
	    return message;
	}
}
