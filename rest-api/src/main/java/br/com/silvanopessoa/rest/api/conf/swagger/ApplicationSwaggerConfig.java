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

import java.util.List;

import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
				.securitySchemes(newArrayList(securitySchema()))
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
	
	private OAuth securitySchema() {
		GrantType passwordGrantType = new ResourceOwnerPasswordCredentialsGrant("oauth/token");
		return new OAuth(securityOAuth2, newArrayList(new AuthorizationScope("read", "read"), new AuthorizationScope("write", "write")),newArrayList(passwordGrantType));
	}

	@Bean
	public SecurityConfiguration securityConfiguration() {
		SecurityConfiguration config = new SecurityConfiguration("yourclientid", "yourclientsercret", "yourrealm","yourappname", "yourapiKey", ",");
		return config;
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = new AuthorizationScope("write", "write");
		return newArrayList(new SecurityReference(securityOAuth2, authorizationScopes));
	}





	/*
	 * private class PasswordTokenRequestEndpoint extends TokenRequestEndpoint {
	 * 
	 * private final String _username; private final String _password;
	 * 
	 * public PasswordTokenRequestEndpoint(String url, String clientIdName,
	 * String clientSecretName, String username, String password) {
	 * 
	 * super(url, clientIdName, clientSecretName); this._username = username;
	 * this._password = password; }
	 * 
	 * @SuppressWarnings("unused") public String getUsername() { return
	 * _username; }
	 * 
	 * @SuppressWarnings("unused") public String getPassword() { return
	 * _password; } }
	 *//**
	 * Class used for Oauth2 password grant type
	 */
	/*
	 * private class OAuth2PasswordCredentialsGrantType extends GrantType {
	 * 
	 * @SuppressWarnings("unused") private final PasswordTokenRequestEndpoint
	 * _tokenRequestEndpoint;
	 * 
	 * public OAuth2PasswordCredentialsGrantType( PasswordTokenRequestEndpoint
	 * tokenRequestEndpoint) { super("password"); this._tokenRequestEndpoint =
	 * tokenRequestEndpoint; } }
	 * 
	 * private List<SecurityContext> securityContext() { return
	 * Arrays.asList(SecurityContext.builder()
	 * .securityReferences(SecurityReferences()) .build()); }
	 * 
	 * private List<SecurityScheme> securitySchemes() {
	 * ArrayList<SecurityScheme> authorizationTypes = new ArrayList<>();
	 * 
	 * not sure why scopes are used for both authorization and authorization
	 * type API is not using the scopes for now
	 * 
	 * List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
	 * authorizationScopeList.add(new AuthorizationScope("read", "read only"));
	 * authorizationScopeList.add(new AuthorizationScope("write",
	 * "read and write"));
	 * 
	 * List<GrantType> grantTypes = new ArrayList<>();
	 * 
	 * TokenRequestEndpoint tokenRequestEndpoint = new
	 * TokenRequestEndpoint("/oauth/token", "client_Id ", "client_secret" );
	 * TokenEndpoint tokenEndpoint = new TokenEndpoint("/oauth/token",
	 * "theToken");
	 * 
	 * PasswordTokenRequestEndpoint passwordTokenRequestEndpoint = new
	 * PasswordTokenRequestEndpoint( "/oauth/token", "client_Id ",
	 * "client_secret", "user", "password"); grantTypes.add(new
	 * OAuth2PasswordCredentialsGrantType( passwordTokenRequestEndpoint));
	 * 
	 * grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint,
	 * tokenEndpoint));
	 * 
	 * OAuth authorization type with client credentials and password grant
	 * types.
	 * 
	 * authorizationTypes.add(new OAuth("oauth2", authorizationScopeList,
	 * grantTypes));
	 * 
	 * return authorizationTypes; }
	 * 
	 * private List<SecurityReference> SecurityReferences() {
	 * 
	 * List<SecurityReference> authorizations = new ArrayList<>();
	 * 
	 * use same scopes as above AuthorizationScope[] authorizationScopes = { new
	 * AuthorizationScope("read", "read only"), new AuthorizationScope("write",
	 * "read and write") };
	 * 
	 * Currently we have 2 roles - user and client authorizations.add(new
	 * SecurityReference("USER", authorizationScopes)); authorizations .add(new
	 * SecurityReference("CLIENT", authorizationScopes));
	 * 
	 * return authorizations;
	 * 
	 * }
	 */
}
