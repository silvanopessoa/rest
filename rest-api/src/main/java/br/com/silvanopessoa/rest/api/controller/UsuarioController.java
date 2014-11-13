package br.com.silvanopessoa.rest.api.controller;

import static br.com.silvanopessoa.rest.api.util.ResponseEntityUtil.createHeaders;
import static org.apache.http.HttpHeaders.IF_MODIFIED_SINCE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
     * Salva o(a) usuario. If a resource has been created on the origin server,
     * the response SHOULD be 201 (Created)
     * 
     * @see http
     *      ://azagorneanu.blogspot.com.br/2013/06/hateoas-using-spring-framework
     *      .html
     * @see http://restpatterns.org/HTTP_Methods/POST
     */
    @RequestMapping(value = "/usuarios", method = POST, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("POST USUARIO | Iniciado | Salvar usuário. Entity:" + usuario);

        LOGGER.info("POST USUARIO | Concluido | Salvar usuário.");
        return new ResponseEntity<Void>(createHeaders(usuario), CREATED);
    }

    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @author silvano.pessoa
     * @param id
     *            o(a) id
     * @return o(a) usuario
     */
    public ResponseEntity<Usuario> getUsuario(@PathVariable("login") String login, @RequestHeader(value = IF_MODIFIED_SINCE, required = false) String dataAlteracao) {
        return null;
    }

    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("login") String login) {
        
        return new ResponseEntity<Usuario>(statusCode)
    }
}
