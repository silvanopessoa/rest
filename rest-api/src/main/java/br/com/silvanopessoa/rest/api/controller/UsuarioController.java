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

import static br.com.silvanopessoa.rest.api.controller.doc.Doc.READ_DESCRIPTION;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.READ_SCOPE;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.USUARIO_NOTES_DELETE_BY_LOGIN;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.USUARIO_NOTES_GET_BY_LOGIN;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.USUARIO_VALUE_DELETE_BY_LOGIN;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.USUARIO_VALUE_GET_BY_LOGIN;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.WRITE_DESCRIPTION;
import static br.com.silvanopessoa.rest.api.controller.doc.Doc.WRITE_SCOPE;
import static br.com.silvanopessoa.rest.api.helper.IdentidadeHelper.getClienteIdFromAuth;
import static br.com.silvanopessoa.rest.lang.base.PreconditionsRest.checkNotFound;
import static org.apache.http.HttpHeaders.IF_MODIFIED_SINCE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

import javax.annotation.security.RolesAllowed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.silvanopessoa.model.usuario.v1.UsuarioType;
import br.com.silvanopessoa.rest.api.conf.swagger.ApplicationSwaggerConfig;
import br.com.silvanopessoa.rest.api.validation.UsuarioValidator;
import br.com.silvanopessoa.rest.model.Usuario;
import br.com.silvanopessoa.rest.model.transformation.UsuarioResourceAssembler;
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
    
    /** O(a)(s) assembler. */
    @Autowired
    private UsuarioResourceAssembler assembler;
    
    /** O(a)(s) header. */
    @Autowired
    private UsuarioHttpHeaders header;
    
    /** O(a)(s) msg. */
    @Autowired
    private UsuarioErrorMessages msg;

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
    public ResponseEntity<Void> createUsuario(@RequestBody UsuarioType usuario) {
        LOGGER.info("POST USUARIO | Iniciado | Salvar usuário. Entity:" + usuario);
        validator.checkCreateRequest(usuario);
        Usuario usuarioEntity = assembler.toEntity(usuario);
        service.salvarUsuario(usuarioEntity);
        LOGGER.info("POST USUARIO | Concluido | Salvar usuário." + usuario);
        return new ResponseEntity<Void>(header.createHeaders(usuarioEntity), CREATED);
    }
    
    /**
     * Atualiza o(a) usuario.
     *  
     * @author silvano.pessoa
     * 
     * @see http://restpatterns.org/HTTP_Methods/PUT
     */
    @RequestMapping(method=PUT, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> updateUsuario(@PathVariable("login") String login, @RequestBody UsuarioType usuario){
        LOGGER.info("PUT USUARIO | Iniciado | Alterar usuário. Usuário: "+login+" Entity:" + usuario);
        String clienteId = getClienteIdFromAuth();
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
    protected ResponseEntity<Void> createUsuarioOrUpdateUsuario(String login, UsuarioType usuario, String clienteId){
        ResponseEntity<Void> responseEntity;
        if(service.isNewUsuario(login,clienteId)){
            LOGGER.info("PUT USUARIO | O usuário é novo e será criado. Usuário: "+login+" Entity:" + usuario);
            responseEntity = this.createUsuario(usuario);
        }else{
            LOGGER.info("PUT USUARIO | O usuário será atualizado. Usuário: "+login+" Entity:" + usuario);
            Usuario usuarioEntity = assembler.toEntity(usuario);
            Usuario usuarioAlterado = service.updateUsuario(login, usuarioEntity, clienteId);
            responseEntity = new ResponseEntity<Void>(header.updateHeaders(usuarioAlterado), NO_CONTENT);
        }
        return responseEntity;
    }
    
    
    /**
     * Exclui o(a) usuario.
     * 
     * @param login o(a) login
     * 
     * @author silvano.pessoa
     * @see http://restpatterns.org/HTTP_Methods/DELETE
     */
	@ApiOperation(
    		value = USUARIO_VALUE_DELETE_BY_LOGIN, 
    		notes = USUARIO_NOTES_DELETE_BY_LOGIN, 
    		authorizations = {@Authorization(
    			value = ApplicationSwaggerConfig.securityOAuth2, 
				scopes = {@AuthorizationScope( scope = WRITE_SCOPE, description = WRITE_DESCRIPTION)})})
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "OK"),
		@ApiResponse(code = 202, message = "Accepted"), 
		@ApiResponse(code = 204, message = "No Content"), 
		@ApiResponse(code = 401, message = "Unauthorized"), 
		@ApiResponse(code = 403, message = "Forbidden"),		
		@ApiResponse(code = 404, message = "Not Found")})
	@RolesAllowed({"ROLE_REST_USER_DELETE"})
    @RequestMapping(value = "/{login}", method = DELETE, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteUsuario(@PathVariable("login") String login) {
        LOGGER.info("DELETE USUARIO | Iniciado | Inativa o usuário:{}",login);
        String clienteId = getClienteIdFromAuth();
        LOGGER.info("DELETE USUARIO | Identificador | Inativa o usuário: {}, cliente: {}",login,clienteId);
        validator.checkDeleteRequest(login, clienteId);
        checkNotFound(service.findByLoginAndClienteId(login, clienteId),msg.deleteCheckNotFoundMessage(login));
        service.deleteUsuario(login, clienteId);
        LOGGER.info("DELETE USUARIO | Concluído | Inativa o usuário: {}, cliente: {}",login,clienteId);
		return new ResponseEntity<>(NO_CONTENT);
    }
    
    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @author silvano.pessoa
     * @param login o(a) login
     * @param dataAlteracao o(a) data alteracao
     * @return o(a) usuario
     * 
     * @author silvano.pessoa
     * @see http://www.restpatterns.org/HTTP_Methods/GET
     */
	@ApiOperation(
    		value = USUARIO_VALUE_GET_BY_LOGIN, 
    		notes = USUARIO_NOTES_GET_BY_LOGIN, 
    		authorizations = {@Authorization(
    			value = ApplicationSwaggerConfig.securityOAuth2, 
				scopes = {@AuthorizationScope( scope = READ_SCOPE, description = READ_DESCRIPTION)})})
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "OK"), 
		@ApiResponse(code = 304, message = "Not Modified"),
		@ApiResponse(code = 401, message = "Unauthorized"), 
		@ApiResponse(code = 403, message = "Forbidden"),		
		@ApiResponse(code = 404, message = "Not Found")})
	@RolesAllowed({"ROLE_REST_USER_FIND"})
	@RequestMapping(value = "/{login}",method = GET, produces = { APPLICATION_XML_VALUE, APPLICATION_JSON_VALUE })
    public ResponseEntity<UsuarioType> getUsuario(@PathVariable("login") String login, @RequestHeader(value = IF_MODIFIED_SINCE, required = false) String dataAlteracao) {
		LOGGER.debug("GET USUARIO | Iniciado | Obtem o usuário. {}");
		String clienteId = getClienteIdFromAuth();
        LOGGER.debug("GET USUARIO | Identificador | Obtem o usuário. Identicador do usuário: {}, cliente: {}, data alteracao: {}",login,clienteId,dataAlteracao);
        validator.checkGetRequest(login, dataAlteracao, clienteId);
        Usuario usuario = service.getUsuario(login, dataAlteracao, clienteId);
        validator.checkGetResponse(usuario);
        UsuarioType resource = assembler.toResource(usuario);
        LOGGER.debug("GET USUARIO | Concluído | Obtem o usuário. Identicador do usuário: {}, cliente: {}, data alteracao: {}, resultado: {}",login,clienteId,dataAlteracao,resource);
        return new ResponseEntity<>(resource,OK);
    }


}
