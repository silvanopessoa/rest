/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  06/07/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.oauth2.provider.check;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Classe responsável por adicionar validações adicionais ao processo de autenticação password.
 * 
 * @author silvano.pessoa
 */
public class PasswordAuthenticationProvider extends DaoAuthenticationProvider {

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.dao.DaoAuthenticationProvider#additionalAuthenticationChecks(org.springframework.security.core.userdetails.UserDetails, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {
        super.additionalAuthenticationChecks(userDetails, authentication);
        //TODO: Adicionar validações ao processo de autenticação password.
    }

}
