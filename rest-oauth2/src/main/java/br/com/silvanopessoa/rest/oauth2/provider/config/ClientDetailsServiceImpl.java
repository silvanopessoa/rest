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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.stereotype.Service;

/**
 * Classe responsável por definir a estratégia para carregar um cliente específico.
 * 
 * @author silvano.pessoa
 */
@Service("clientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService,ClientRegistrationService {
    
    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetailsService#loadClientByClientId(java.lang.String)
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId){
    	LOGGER.info("Obtendo o Cliente pelo clientId.");
    	return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientRegistrationService#addClientDetails(org.springframework.security.oauth2.provider.ClientDetails)
     */
    @Override
    public void addClientDetails(ClientDetails clientDetails){
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientRegistrationService#updateClientDetails(org.springframework.security.oauth2.provider.ClientDetails)
     */
    @Override
    public void updateClientDetails(ClientDetails clientDetails){
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientRegistrationService#updateClientSecret(java.lang.String, java.lang.String)
     */
    @Override
    public void updateClientSecret(String clientId, String secret){
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientRegistrationService#removeClientDetails(java.lang.String)
     */
    @Override
    public void removeClientDetails(String clientId){
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientRegistrationService#listClientDetails()
     */
    @Override
    public List<ClientDetails> listClientDetails() {
    	return null;
    }
    
}

