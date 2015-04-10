package br.com.silvanopessoa.rest.api.validation;

import static br.com.silvanopessoa.rest.api.base.PreconditionsRest.checkNotFound;

import org.springframework.stereotype.Component;

import br.com.silvanopessoa.model.usuario.v1.UsuarioType;
import br.com.silvanopessoa.rest.model.Usuario;

/**
 * O(a) Class UsuarioValidator.
 *
 * @author silvano.pessoa
 * @since 16/11/2014 - 23:00:12
 */
@Component
public class UsuarioValidator{
    
    /**
     * Check create request.
     *
     * @param usuario o(a) usuario
     */
    public void checkCreateRequest(UsuarioType usuario){
        
    }
    
    /**
     * Check update request.
     *
     * @param login o(a) login
     * @param usuario o(a) usuario
     */
    public void checkUpdateRequest(String login, UsuarioType usuario){
        
    }
    
    /**
     * Check delete request.
     *
     * @param login o(a) login
     * @param clienteId o(a) cliente id
     */
    public void checkDeleteRequest(String login, String clienteId){
        
    }
    
    /**
     * Check before get request.
     *
     * @param login o(a) login
     * @param dataAlteracao o(a) data alteracao
     * @param clienteId o(a) cliente id
     */
    public void checkGetRequest(String login, String dataAlteracao, String clienteId){
        
    }
    
    /**
     * Check after get request.
     *
     * @param usuario o(a) usuario
     */
    public void checkGetResponse(Usuario usuario){
        checkNotFound(usuario);
    }
}
