package br.com.silvanopessoa.rest.api.controller;

import static br.com.silvanopessoa.rest.api.base.PreconditionsRest.checkNotFound;
import static br.com.silvanopessoa.rest.api.util.ResponseEntityUtil.createHeaders;
import static org.apache.http.HttpHeaders.IF_MODIFIED_SINCE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.silvanopessoa.rest.api.model.Usuario;
import br.com.silvanopessoa.rest.api.validation.UsuarioValidator;
import br.com.silvanopessoa.rest.service.UsuarioService;

/**
 * O(a) Class UsuarioController.
 *
 * @author silvano.pessoa
 * @see http://spring.io/guides/gs/rest-service/
 * @since 25/10/2014 - 23:56:38
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioController.class);
    
    /** O(a) validator. */
    @Autowired
    private UsuarioValidator validator;
    
    /** O(a) service. */
    @Autowired
    private UsuarioService service;

    /**
     * Salva o(a) usuario. 
     * 
     * If a resource has been created on the origin server,
     * 
     * Resposta: the response SHOULD be 201 (Created)
     * @author silvano.pessoa
     * 
     * @param usuario o(a) usuario
     * @return the response entity
     * 
     * @see http://azagorneanu.blogspot.com.br/2013/06/hateoas-using-spring-framework.html
     * @see http://restpatterns.org/HTTP_Methods/POST
     */
    @RequestMapping(method = POST, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> createUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("POST USUARIO | Iniciado | Salvar usuário. Entity:" + usuario);
        validator.checkCreateRequest(usuario);
        LOGGER.info("POST USUARIO | Concluido | Salvar usuário." + usuario);
        return new ResponseEntity<Void>(createHeaders(usuario), CREATED);
    }
    
    /**
     * Atualiza o(a) usuario.
     *  
     * @author silvano.pessoa
     * 
     * @see http://restpatterns.org/HTTP_Methods/PUT
     */
    @RequestMapping(method=PUT, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> updateUsuario(@PathVariable("login") String login, @RequestBody Usuario usuario){
        LOGGER.info("PUT USUARIO | Iniciado | Alterar usuário. Usuário: "+login+" Entity:" + usuario);
        String clienteId ="";//TODO: IMPLEMENTAR
        validator.checkUpdateRequest(login, usuario);
        ResponseEntity<Void> responseEntity = this.createUsuarioOrUpdateUsuario(login, usuario,clienteId);
        LOGGER.info("PUT USUARIO | Concluido | Alterar usuário. Usuário: "+login);
        return responseEntity;
    }
    
    /**
     * Creates the usuario or update usuario.
     *
     * @param login o(a) login
     * @param usuario o(a) usuario
     * @param clienteId o(a) cliente id
     * @return the response entity
     */
    protected ResponseEntity<Void> createUsuarioOrUpdateUsuario(String login, Usuario usuario, String clienteId){
        ResponseEntity<Void> responseEntity;
        if(service.isNewUsuario(login,clienteId)){
            LOGGER.info("PUT USUARIO | O usuário é novo e será criado. Usuário: "+login+" Entity:" + usuario);
            responseEntity = this.createUsuario(usuario);
        }else{
            LOGGER.info("PUT USUARIO | O usuário será atualizado. Usuário: "+login+" Entity:" + usuario);
            Usuario usuarioAlterado = service.updateUsuario(login, usuario, clienteId);
            responseEntity = new ResponseEntity<Void>(createHeaders(usuarioAlterado), NO_CONTENT);//TODO: UPDATE TEM LOCATION?
        }
        return responseEntity;
    }
    
    
    /**
     * Exclui o(a) usuario.
     * 
     * Resposta: 204 (No Content) if the action has been enacted but the response does not include an entity.
     * Resposta: 404
     * 
     * @author silvano.pessoa
     * @see http://restpatterns.org/HTTP_Methods/DELETE
     * @param login o(a) login
     */
    @ResponseStatus(NO_CONTENT)
    public void deleteUsuario(@PathVariable("login") String login) {
        LOGGER.info("DELETE USUARIO | Iniciado | Usuário:" + login);
        String clienteId ="";//TODO: IMPLEMENTAR
        checkNotFound(service.findByLoginAndClienteId(login, clienteId));
        //NOT FOUND 404
        //Not Content 204
        LOGGER.info("DELETE USUARIO | Concluído | Usuário:" + login);
    }
    
    
    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @author silvano.pessoa
     * @param login o(a) login
     * @param dataAlteracao o(a) data alteracao
     * @return o(a) usuario
     */
    @RequestMapping(value = "/{login}",method = GET, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Usuario> getUsuario(@PathVariable("login") String login, @RequestHeader(value = IF_MODIFIED_SINCE, required = false) String dataAlteracao) {
        LOGGER.info("GET USUARIO | Iniciado | Obtem o usuário. Indenticador do usuário:" + login);
        //TODO: Validar data de alteração.
        LOGGER.info("GET USUARIO | Concluido | Obtem o usuário.");
        return null;
    }


}
