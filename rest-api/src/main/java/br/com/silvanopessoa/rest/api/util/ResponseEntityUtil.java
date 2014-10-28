package br.com.silvanopessoa.rest.api.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpHeaders;

import br.com.silvanopessoa.rest.api.controller.UsuarioController;
import br.com.silvanopessoa.rest.api.model.Usuario;

public class ResponseEntityUtil {

    public static HttpHeaders createHeaders(Usuario usuario){
        HttpHeaders headers = new HttpHeaders();
        if (usuario != null) {
            headers.setLocation(linkTo(methodOn(UsuarioController.class).getUsuario(usuario.getId(), null)).toUri());
            if (usuario.getDataAlteracao() != null) {
                headers.setLastModified(usuario.getDataAlteracao().getMillis());
            }
        }
        return headers;
    }
}
