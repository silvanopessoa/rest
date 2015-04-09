package br.com.silvanopessoa.rest.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import br.com.silvanopessoa.rest.model.Usuario;

/**
 * The Class UsuarioHttpHeaders.
 */
@Component
public class UsuarioHttpHeaders {

    /**
     * Cria o cabeçalho.
     * Contain an entity which describes the status of the request and refers to the new resource, and a Location header (see section 14.30).
     *
     * @param usuario the usuario
     * @return the http headers
     * @see http://restpatterns.org/HTTP_Methods/POST
     * @see https://spring.io/guides/gs/rest-hateoas/
     */
    public HttpHeaders createHeaders(Usuario usuario){
        HttpHeaders headers = new HttpHeaders();
        if (usuario != null) {
        	if(usuario.getId()!=null){
        		headers.setLocation(linkTo(methodOn(UsuarioController.class).getUsuario(usuario.getId(), null)).toUri());
        	}
        	if(usuario.getDataAlteracao()!=null){
        		headers.setLastModified(usuario.getDataAlteracao().getMillis());
        	}
        }
        
        return headers;
    }
    
    /**
     * Update headers.
     *
     * @param usuario the usuario
     * @return the http headers
     */
    public HttpHeaders updateHeaders(Usuario usuario){
    	return this.createHeaders(usuario);
    }
}
