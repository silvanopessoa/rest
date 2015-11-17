/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  30/10/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.conf.swagger;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class ApplicationSwaggerConfig.
 */
@EnableSwagger2
public class ApplicationSwaggerConfig {

	/** A Constante securityOAuth2. */
	public static final String securityOAuth2 = "oauth2";

	/**
	 * Rest api.
	 * 
	 * Configurações do Swagger.
	 *
	 * @return O(a)(s) docket
	 */
	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.directModelSubstitute(DateTime.class, String.class)
				.securitySchemes(securitySchema())
				.securityContexts(newArrayList(securityContext()));
	}
	
	/**
	 * Api info.
	 * 
	 * Define informações sobre a API na página principal do Swagger.
	 *
	 * @return O(a)(s) api info
	 */
	protected ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("API REST",
				"Arquitetura de uma API Rest", 
				"1.0", 
				"Terms od Service",
				"Silvano Pessoa", 
				"Lincença",
				"https://github.com/silvanopessoa");
		return apiInfo;
	}
	
	/**
	 * Security schema.
	 *
	 * @return O(a)(s) list
	 */
	private List<SecurityScheme> securitySchema() {
		ArrayList<SecurityScheme> authorizationTypes = new ArrayList<>();
		
        List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        authorizationScopeList.add(new AuthorizationScope("read", "read only"));
        authorizationScopeList.add(new AuthorizationScope("write", "read and write"));
        
        List<GrantType> grantTypes = new ArrayList<>();
        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint("/rest-api/oauth/token", "client_Id ", "client_secret" );
        //TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint("/rest-api/oauth/token", "0 ", "d0f3e83e-16ba-4272-88f8-78f131408bfb" );
        TokenEndpoint tokenEndpoint = new TokenEndpoint("/oauth/token", "theToken");
        
        PasswordTokenRequestEndpoint passwordTokenRequestEndpoint = new PasswordTokenRequestEndpoint("/oauth/token", "client_Id ", "client_secret", "silvano", "12345678");
        //PasswordTokenRequestEndpoint passwordTokenRequestEndpoint = new PasswordTokenRequestEndpoint("/rest-api/oauth/token", "0 ", "d0f3e83e-16ba-4272-88f8-78f131408bfb", "silvano", "12345678");
        grantTypes.add(new OAuth2PasswordCredentialsGrantType(passwordTokenRequestEndpoint));
        grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
        
        authorizationTypes.add(new OAuth("oauth2", authorizationScopeList, grantTypes));

        return authorizationTypes;
	}

	/**
	 * Security configuration.
	 *
	 * @return O(a)(s) security configuration
	 */
	@Bean
	public SecurityConfiguration securityConfiguration() {
//		SecurityConfiguration config = new SecurityConfiguration("yourclientid", "yourclientsercret", "yourrealm","yourappname", "yourapiKey", ",");
		SecurityConfiguration config = new SecurityConfiguration("12", "d0f3e83e-16ba-4272-88f8-78f131408bfb", "rest-api","silvano", "12345678", ",");
		return config;
	}

	/**
	 * Security context.
	 *
	 * @return O(a)(s) security context
	 */
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	/**
	 * Default auth.
	 *
	 * @return O(a)(s) list
	 */
	private List<SecurityReference> defaultAuth() {
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = new AuthorizationScope("write", "write");
		return newArrayList(new SecurityReference(securityOAuth2, authorizationScopes));
	}

	/**
	 * The Class PasswordTokenRequestEndpoint.
	 */
	private class PasswordTokenRequestEndpoint extends TokenRequestEndpoint {
	    
    	/** O(a)(s) _username. */
    	private final String _username;
	    
    	/** O(a)(s) _password. */
    	private final String _password;
	    
    	/**
    	 * Instancia um novo(a) password token request endpoint.
    	 *
    	 * @param url O(a)(s) url
    	 * @param clientIdName O(a)(s) client id name
    	 * @param clientSecretName O(a)(s) client secret name
    	 * @param username O(a)(s) username
    	 * @param password O(a)(s) password
    	 */
    	public PasswordTokenRequestEndpoint(String url, String clientIdName,
	            String clientSecretName, String username, String password) {

	        super(url, clientIdName, clientSecretName);
	        this._username = username;
	        this._password = password;
	    }
	    
    	/**
    	 * Obtém o valor do(a)(s) username.
    	 *
    	 * @return O(a)(s) username
    	 */
    	@SuppressWarnings("unused")
	    public String getUsername() {
	        return _username;
	    }
	    
    	/**
    	 * Obtém o valor do(a)(s) password.
    	 *
    	 * @return O(a)(s) password
    	 */
    	@SuppressWarnings("unused")
	    public String getPassword() {
	        return _password;
	    }
	}
	
	/**
	 * The Class OAuth2PasswordCredentialsGrantType.
	 */
	private class OAuth2PasswordCredentialsGrantType extends ResourceOwnerPasswordCredentialsGrant {
        
        /** O(a)(s) _token request endpoint. */
        @SuppressWarnings("unused")
        private final PasswordTokenRequestEndpoint _tokenRequestEndpoint;

        /**
         * Instancia um novo(a) o auth2 password credentials grant type.
         *
         * @param tokenRequestEndpoint O(a)(s) token request endpoint
         */
        public OAuth2PasswordCredentialsGrantType(PasswordTokenRequestEndpoint tokenRequestEndpoint) {
            super("password");
            this._tokenRequestEndpoint = tokenRequestEndpoint;
        }
    }

}


