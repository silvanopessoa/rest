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
package br.com.silvanopessoa.rest.oauth2.provider.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import br.com.silvanopessoa.rest.oauth2.token.entity.CustomClientDetails;

/**
 * Classe responsável por definir a estratégia para carregar um cliente específico.
 * 
 * @author silvano.pessoa
 */
@Service("clientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService{
    
    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetailsService#loadClientByClientId(java.lang.String)
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId){
    	LOGGER.info("Obtendo o Cliente pelo clientId.");
    	return mockClientDetails();
    }
    
    /**
     * Mock client details.
     *
     * @return O(a)(s) client details
     */
    private ClientDetails mockClientDetails(){
    	CustomClientDetails customClientDetails = new CustomClientDetails();
    	customClientDetails.setClientId("0");
    	customClientDetails.setEnabled(true);
    	Set<String> scope = new HashSet<String>();
    	scope.add("read");
    	scope.add("write");
    	customClientDetails.setScope(scope);
    	Set<String> authorizedGrantTypes = new HashSet<String>();
    	authorizedGrantTypes.add("password");
    	authorizedGrantTypes.add("refresh_token");
    	customClientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
    	customClientDetails.setClientSecret("$2a$10$AS30Aq4frR7cpQu.fu1MmeHJhark3LOAC4wR3uUBrNyVMk9MZRTeu");
    	customClientDetails.setRefreshTokenValiditySeconds(15000);
    	customClientDetails.setSecretRequired(true);
    	customClientDetails.setAccessTokenValiditySeconds(15000);
    	Collection<GrantedAuthority> collection = new ArrayList<GrantedAuthority>();
    	SimpleGrantedAuthority authority1 = new SimpleGrantedAuthority("ROLE_CLIENT");
    	SimpleGrantedAuthority authority2 = new SimpleGrantedAuthority("ROLE_TRUSTED_CLIENT");
    	collection.add(authority1);
    	collection.add(authority2);
    	customClientDetails.setAuthorities(collection);
    	customClientDetails.setName("Cliente Teste");
    	customClientDetails.setScoped(true);
    	
    	return customClientDetails;
    }

}

