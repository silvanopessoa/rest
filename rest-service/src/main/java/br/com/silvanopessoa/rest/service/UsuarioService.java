/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  21/07/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.service;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import br.com.silvanopessoa.rest.model.Usuario;

/**
 * O(a) Class UsuarioService.
 *
 * @author silvano.pessoa
 * @since 16/11/2014 - 22:54:22
 */
@Service
public class UsuarioService {

    /**
     * Find by login and cliente id.
     *
     * @param login o(a) login
     * @param clienteId o(a) cliente id
     * @return the usuario
     */
    public Usuario findByLoginAndClienteId(String login, String clienteId) {
        return null;
    }

    /**
     * Verifica se é new usuario.
     *
     * @author silvano.pessoa
     * @param login o(a) login
     * @return true, se for new usuario
     */
    public boolean isNewUsuario(String login, String clienteId) {
        return login == null || this.findByLoginAndClienteId(login, clienteId) == null;
    }

    /**
     * Atualiza o(a) usuario.
     *
     * @param login o(a) login
     * @param usuario o(a) usuario
     * @param clienteId o(a) cliente id
     * @return the usuario
     */
    public Usuario updateUsuario(String login, Usuario usuario, String clienteId) {
        return null;
    }
    
    /**
     * Delete usuario.
     *
     * @param login o(a) login
     * @param clienteId o(a) cliente id
     */
    public void deleteUsuario(String login, String clienteId){
        
    }

    /**
     * Obtém o valor do(a)(s) usuario.
     *
     * @author silvano.pessoa
     * @param login o(a) login
     * @param dataAlteracao o(a) data alteracao
     * @param clienteId o(a) cliente id
     * @return o(a) usuario
     */
    public Usuario getUsuario(String login, String dataAlteracao, String clienteId) {
        Usuario usuario = new Usuario();
        usuario.setId("silvano@web");
        usuario.setDataAlteracao(DateTime.now());
        return usuario;
    }

	/**
	 * Salvar usuario.
	 *
	 * @param usuarioEntity O(a)(s) usuario entity
	 * @param clienteId O(a)(s) cliente id
	 */
	public void salvarUsuario(Usuario usuarioEntity, String clienteId) {
		
	}
}
