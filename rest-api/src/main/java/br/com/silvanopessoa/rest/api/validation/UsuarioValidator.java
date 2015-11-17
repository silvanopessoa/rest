/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  20/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.validation;

import static br.com.silvanopessoa.rest.lang.base.PreconditionsRest.checkNotFound;

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
     * @param usuario O(a)(s) usuario
     * @param clienteId O(a)(s) cliente id
     */
    public void checkCreateRequest(UsuarioType usuario, String clienteId){
        
    }
    
    /**
     * Check update request.
     *
     * @param login O(a)(s) login
     * @param usuario O(a)(s) usuario
     * @param clienteId O(a)(s) cliente id
     */
    public void checkUpdateRequest(String login, UsuarioType usuario, String clienteId){
        
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
