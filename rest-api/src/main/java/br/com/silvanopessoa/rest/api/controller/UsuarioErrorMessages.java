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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.silvanopessoa.rest.api.messages.MessageBundleUtil;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * A classe UsuarioErrorMessages é responsável por gerar mensagens de erros.
 */
@Component
public class UsuarioErrorMessages {

    @Autowired
    private MessageBundleUtil msg;
    
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
	    message.setTitle(msg.getMessage("error_message_usuario_title_delete_check_not_found_type"));
	    message.setDetail(msg.getMessage("error_message_usuario_title_delete_check_not_found_detail")+login);
	    message.setInstance(linkTo(methodOn(UsuarioController.class).getUsuario(login, null)).toUri());
	    return message;
	}
}
