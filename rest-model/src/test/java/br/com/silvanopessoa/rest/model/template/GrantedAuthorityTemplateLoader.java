/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  25/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.model.template;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.silvanopessoa.rest.test.util.fixturefactory.extension.CustomRule;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class GrantedAuthorityTemplateLoader.
 * 
 * @see org.springframework.security.core.GrantedAuthority
 * @see SimpleGrantedAuthority
 */
public class GrantedAuthorityTemplateLoader implements TemplateLoader{

	@Override
	public void load() {
		Fixture.of(SimpleGrantedAuthority.class).addTemplate("valid", new CustomRule(){{
			add("role",regex("ROLE_([A-Z]{5,10})_([A-Z]{5,10})"));
		}});
	
	}


}
