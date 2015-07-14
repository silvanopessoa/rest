/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  05/06/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.oauth2.provider.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.InvalidMimeTypeException;

import br.com.silvanopessoa.rest.model.Usuario;

/**
 * A Classe UserDetailsServiceImpl é responsável por retornar um usuário do tipo UserDetails com suas permissões.
 * Define a estratégia para carregar um usuário específico.
 * 
 * @author silvano.pessoa
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String login) {
    	LOGGER.info("Obtendo o usuário pelo login.");
    	return this.mockUserDetails();
    }
    
    private Usuario mockUserDetails(){
    	Usuario usuario = new Usuario();
    	usuario.setId("silvano");
    	usuario.setPassword("$2a$10$aSD/iVbXwHV9A1tyaasYqutteIXxqHMzOoQAyJZw9ogAELdHhdQ8u");
    	usuario.setAccountNonLocked(true);
    	usuario.setEnabled(true);
    	return usuario;
    }
}
