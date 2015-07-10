package br.com.silvanopessoa.rest.oauth2.converter;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import br.com.silvanopessoa.rest.model.Usuario;

import com.google.common.collect.Sets;
import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

/**
 * The Class OAuth2AuthenticationReadConverter.
 * 
 * Hackery to deserialize back into an OAuth2Authentication Object made necessary because Spring Mongo can't map clientAuthentication to authorizationRequest
 */
@ReadingConverter
@SuppressWarnings("unchecked")
public class OAuth2AuthenticationReadConverter implements Converter<DBObject, OAuth2Authentication> {

    /** LOG. */
    private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2AuthenticationReadConverter.class);

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OAuth2Authentication convert(DBObject source) {
        DBObject userAuthentication = (DBObject) source.get("userAuthentication");
        DBObject storeRequest = (DBObject) source.get("storedRequest");

        // userAuthentication The user authentication (possibly null).
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = extractUserAuthentication(userAuthentication);

        // authorizationRequest The authorization request (must not be null).
        OAuth2Request oAuth2Request = extractOAuth2Request(storeRequest);

        // An OAuth 2 authentication token can contain two authentications: one for the client and one for the user. Since some
        // OAuth authorization grants don't require user authentication, the user authentication may be null.
        return new OAuth2Authentication(oAuth2Request, usernamePasswordAuthenticationToken);
    }

    /**
     * Extract o auth2 request.
     *
     * @param storeRequest O(a)(s) store request
     * @return O(a)(s) o auth2 request
     */
    public OAuth2Request extractOAuth2Request(DBObject storeRequest) {

        BasicDBList dbScope = safeCast(BasicDBList.class, storeRequest.get("scope"));

        Set<String> scope = extractList(dbScope);

        BasicDBList dbResponseTypes = safeCast(BasicDBList.class, storeRequest.get("responseTypes"));

        Set<String> responseTypes = extractList(dbResponseTypes);

        Map<String, String> requestParameters = (Map<String, String>) storeRequest.get("requestParameters");

        Collection<GrantedAuthority> clientAuthorities = getAuthorities((List<Map<String, String>>) storeRequest.get("authorities"));

        return new OAuth2Request(requestParameters, (String) storeRequest.get("clientId"), clientAuthorities, (boolean) storeRequest.get("approved"), scope, new HashSet<String>(),
            (String) storeRequest.get("redirectUri"), responseTypes, (Map<String, Serializable>) storeRequest.get("extensions"));
    }

    /**
     * Extract list.
     *
     * @param dbScope O(a)(s) db scope
     * @return O(a)(s) sets the
     */
    private Set<String> extractList(BasicDBList dbScope) {
        Set<String> scope = Sets.newHashSet();
        for(Object object : dbScope) {
            scope.add(object.toString());
        }
        return scope;
    }

    /**
     * Extract user authentication.
     *
     * @param userAuthentication O(a)(s) user authentication
     * @return O(a)(s) username password authentication token, the user authentication may be null.
     */
    public UsernamePasswordAuthenticationToken extractUserAuthentication(DBObject userAuthentication) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
        if (userAuthentication != null) {
            Collection<GrantedAuthority> authorities = getAuthorities((List<Map<String, String>>) userAuthentication.get("authorities"));
            Object principal = getPrincipalObject((Map<String, Object>) userAuthentication.get("principal"), authorities);
            usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(principal, userAuthentication.get("credentials"), authorities);

        }
        return usernamePasswordAuthenticationToken;
    }

    /**
     * Obtém o valor do(a)(s) principal object.
     *
     * @param principal O(a)(s) principal
     * @param authorities O(a)(s) authorities
     * @return O(a)(s) principal object
     */
    private Object getPrincipalObject(Map<String, Object> principal, Collection<GrantedAuthority> authorities) {
        if (principal instanceof DBObject) {
            Usuario usuario = new Usuario();
            usuario.setClienteId(safeCast(Integer.class, principal.get("clienteId")));
            return usuario;
        } else {
            return principal;
        }
    }

    /**
     * Extract identidade.
     *
     * @param principal O(a)(s) principal
     * @return O(a)(s) identidade
     */
//    public Identidade extractIdentidade(DBObject principal) {
//        DBObject identidadeUsuarioDb = (DBObject) principal.get("identidade");
//        return Identidade.create(safeCast(String.class, identidadeUsuarioDb.get("usuarioSemApelido")), safeCast(String.class, identidadeUsuarioDb.get("apelidoCliente")));
//    }

    /**
     * Safe cast.
     *
     * @param <T> O tipo genérico
     * @param classe O(a)(s) classe
     * @param object O(a)(s) object
     * @return O(a)(s) t
     */
    protected <T> T safeCast(Class<T> classe, Object object) {
        if (object == null) {
            return null;
        }
        if (object.getClass().isAssignableFrom(classe)) {
            return classe.cast(object);
        } else {
            LOGGER.error("Objeto de tipo diferente");
            return null;
        }

    }

    /**
     * Obtém o valor do(a)(s) authorities.
     *
     * @param authorities O(a)(s) authorities
     * @return O(a)(s) authorities
     */
    protected Collection<GrantedAuthority> getAuthorities(List<Map<String, String>> authorities) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(authorities.size());
        for(Map<String, String> authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.get("role")));
        }
        return grantedAuthorities;
    }

}
