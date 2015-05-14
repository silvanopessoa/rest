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

import org.springframework.stereotype.Component;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * The Class UsuarioErrorMessages.
 */
@Component
public class UsuarioErrorMessages {

	/**
	 * Delete check not found message.
	 *
	 * @param login O(a)(s) login
	 * @return O(a)(s) error message
	 */
	public ErrorMessage deleteCheckNotFoundMessage(String login){
	    ErrorMessage message = new ErrorMessage();
	    message.setType(null);
	    message.setTitle("Não foi possível excluir o usuário.");
	    message.setDetail("O usuário não foi encontrado para o identificador: "+login);
	    message.setInstance(linkTo(methodOn(UsuarioController.class).getUsuario(login, null)).toUri());
	    return message;
	}
}
