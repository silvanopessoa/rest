/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  04/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.helper;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.silvanopessoa.rest.model.Usuario;

/**
 * The Class IdentidadeHelper.
 */
public final class IdentidadeHelper {

	/**
	 * Instancia um novo(a) identidade helper.
	 */
	private IdentidadeHelper() {
	}
	
    /**
     * Obtém o valor do(a)(s) cliente id from auth.
     *
     * @return O(a)(s) cliente id from auth
     */
    public static final String getClienteIdFromAuth() {
        String tenantId = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof Usuario) {
                Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                if (usuario != null) {
                    tenantId = usuario.getClienteId();
                }
            }
        }
        return tenantId;
    }

}
