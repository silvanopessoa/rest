package br.com.silvanopessoa.rest.api.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.silvanopessoa.rest.api.model.Usuario;

/**
 * O(a) Class UsuarioController.
 *
 * @author silvano.pessoa
 * @see http://spring.io/guides/gs/rest-service/
 * @since 25/10/2014 - 23:56:38
 */
@RestController
public class UsuarioController {

    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);

    /**
     * Salva o(a) usuario.
     * 
     * http://azagorneanu.blogspot.com.br/2013/06/hateoas-using-spring-framework.html
     * http://restpatterns.org/HTTP_Methods/POST
     */
    @RequestMapping(value = "/usuarios", method = POST, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("Salvar usuário.");
        // If a resource has been created on the origin server, the response SHOULD be 201 (Created)
        return new ResponseEntity<Void>(CREATED);
    }

    public ResponseEntity<Usuario> getUsuario(Long id, Object object) {
        return null;
    }
}
