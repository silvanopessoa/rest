package br.com.silvanopessoa.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.stereotype.Component;

import cz.jirutka.spring.exhandler.messages.ErrorMessage;

@Component
public class UsuarioErrorMessages {

	public ErrorMessage deleteCheckNotFoundMessage(String login){
	    ErrorMessage message = new ErrorMessage();
	    message.setType(null);
	    message.setTitle("Não foi possível excluir o usuário.");
	    message.setDetail("O usuário não foi encontrado para o identificador: "+login);
	    message.setInstance(linkTo(methodOn(UsuarioController.class).getUsuario(login, null)).toUri());
	    return message;
	}
}
