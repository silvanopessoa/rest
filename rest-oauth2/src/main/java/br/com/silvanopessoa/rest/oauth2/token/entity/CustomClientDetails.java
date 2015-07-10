package br.com.silvanopessoa.rest.oauth2.token.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import br.com.silvanopessoa.rest.lang.base.AbstractPersistable;

@TypeAlias("customClientDetails")
@Document(collection = "customClientDetails")
public class CustomClientDetails extends AbstractPersistable<String> implements ClientDetails {
 
    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** nome do client, utilizado somente para facilitar identificacao. */
    private String name;
    
    /** O(a)(s) client secret. */
    private String clientSecret;
    
    /** O(a)(s) resource ids. */
    private Set<String> resourceIds;
    
    /** O(a)(s) authorized grant types. */
    private Set<String> authorizedGrantTypes;
    
    /** O(a)(s) scope. */
    private Set<String> scope;
    
    /** O(a)(s) registered redirect uri. */
    private  Set<String> registeredRedirectUri;
    
    /** O(a)(s) secret required. */
    private boolean secretRequired = true;
    
    /** O(a)(s) authorities. */
    private Collection<GrantedAuthority> authorities;
    
    /** O(a)(s) access token validity seconds. */
    private Integer accessTokenValiditySeconds;
    
    /** O(a)(s) refresh token validity seconds. */
    private Integer refreshTokenValiditySeconds;
    
    /** O(a)(s) auto approve. */
    private boolean autoApprove;

    /** O(a)(s) scoped. */
    private boolean scoped = true;
    
    /** O(a)(s) enabled. */
    private boolean enabled = true;
    
   
    /**
     * Instancia um novo(a) custom client details.
     */
    public CustomClientDetails() {
    }
    
    /**
     * Instancia um novo(a) custom client details.
     *
     * @param id O(a)(s) id
     */
    public CustomClientDetails(String id) {
        this.setId(id);
    }

    /**
     * Define o valor do(a)(s) client id.
     *
     * @param clientId o novo valor do(a)(s) client id
     */
    public void setClientId(String clientId) {
        setId(clientId);
    }

    /**
     * Define o valor do(a)(s) client secret.
     *
     * @param clientSecret o novo valor do(a)(s) client secret
     */
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * Define o valor do(a)(s) resource ids.
     *
     * @param resourceIds o novo valor do(a)(s) resource ids
     */
    public void setResourceIds(Set<String> resourceIds) {
        this.resourceIds = resourceIds;
    }

    /**
     * Define o valor do(a)(s) authorized grant types.
     *
     * @param authorizedGrantTypes o novo valor do(a)(s) authorized grant types
     */
    public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    /**
     * Define o valor do(a)(s) scope.
     *
     * @param scope o novo valor do(a)(s) scope
     */
    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    /**
     * Define o valor do(a)(s) registered redirect uri.
     *
     * @param registeredRedirectUri o novo valor do(a)(s) registered redirect uri
     */
    public void setRegisteredRedirectUri(Set<String> registeredRedirectUri) {
        this.registeredRedirectUri = registeredRedirectUri;
    }

    /**
     * Define o valor do(a)(s) secret required.
     *
     * @param secretRequired o novo valor do(a)(s) secret required
     */
    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    /**
     * Define o valor do(a)(s) authorities.
     *
     * @param authorities o novo valor do(a)(s) authorities
     */
    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    /**
     * Define o valor do(a)(s) access token validity seconds.
     *
     * @param accessTokenValiditySeconds o novo valor do(a)(s) access token validity seconds
     */
    public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
        this.accessTokenValiditySeconds = accessTokenValiditySeconds;
    }

    /**
     * Define o valor do(a)(s) refresh token validity seconds.
     *
     * @param refreshTokenValiditySeconds o novo valor do(a)(s) refresh token validity seconds
     */
    public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
        this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
    }

    /**
     * Define o valor do(a)(s) auto approve.
     *
     * @param autoApprove o novo valor do(a)(s) auto approve
     */
    public void setAutoApprove(boolean autoApprove) {
        this.autoApprove = autoApprove;
    }

    /**
     * Define o valor do(a)(s) scoped.
     *
     * @param scoped o novo valor do(a)(s) scoped
     */
    public void setScoped(boolean scoped) {
        this.scoped = scoped;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getClientId()
     */
    @Override
    public String getClientId() {
        return getId();
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getResourceIds()
     */
    @Override
    public Set<String> getResourceIds() {
        return resourceIds;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#isSecretRequired()
     */
    @Override
    public boolean isSecretRequired() {
        return secretRequired;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getClientSecret()
     */
    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#isScoped()
     */
    @Override
    public boolean isScoped() {
        return scoped;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getScope()
     */
    @Override
    public Set<String> getScope() {
        return scope;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getAuthorizedGrantTypes()
     */
    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getRegisteredRedirectUri()
     */
    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getAuthorities()
     */
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getAccessTokenValiditySeconds()
     */
    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getRefreshTokenValiditySeconds()
     */
    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#isAutoApprove(java.lang.String)
     */
    @Override
    public boolean isAutoApprove(String scope) {
        return autoApprove;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.oauth2.provider.ClientDetails#getAdditionalInformation()
     */
    @Override
    public Map<String, Object> getAdditionalInformation() {
        return Collections.emptyMap();
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Define o valor do(a)(s) enabled.
     *
     * @param enabled o novo valor do(a)(s) enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Obtém o valor do(a)(s) name.
     *
     * @return O(a)(s) name
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor do(a)(s) name.
     *
     * @param name o novo valor do(a)(s) name
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
