package br.com.silvanopessoa.rest.api.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpHeaders;

import br.com.silvanopessoa.rest.api.controller.UsuarioController;
import br.com.silvanopessoa.rest.api.model.Usuario;

public class ResponseEntityUtil {

    /**
     * Cria o cabeçalho.
     * Contain an entity which describes the status of the request and refers to the new resource, and a Location header (see section 14.30).
     * 
     * @see http://restpatterns.org/HTTP_Methods/POST
     * @see https://spring.io/guides/gs/rest-hateoas/
     * 
     * @param usuario the usuario
     * @return the http headers
     */
    public static HttpHeaders createHeaders(Usuario usuario){
        HttpHeaders headers = new HttpHeaders();
        if (usuario != null) {
            headers.setLocation(linkTo(methodOn(UsuarioController.class).getUsuario(usuario.getLogin(), null)).toUri());
        }
        return headers;
    }
}
