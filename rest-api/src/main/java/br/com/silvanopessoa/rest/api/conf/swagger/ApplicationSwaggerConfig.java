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

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class ApplicationSwaggerConfig {

	@Bean
	public Docket petApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo()).securitySchemes(newArrayList(apiKey()))
			.securityContexts(newArrayList(securityContext()))
			;
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
				"Arquitetura de uma API Rest", "1.0", "Terms od Service",
				"Silvano Pessoa", "Lincença",
				"https://github.com/silvanopessoa");
		return apiInfo;
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("mykey", authorizationScopes));
	}
	
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*")).build();
	}
	
	private ApiKey apiKey() {
		return new ApiKey("mykey", "api_key", "header");
	}
	
	@Bean
	SecurityConfiguration security() {
		return new SecurityConfiguration("test-app-client-id", "test-app-realm", "test-app", "apiKey");
	}
}
