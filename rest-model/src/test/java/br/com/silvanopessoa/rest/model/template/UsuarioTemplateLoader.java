/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  19/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.model.template;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.silvanopessoa.rest.model.Usuario;
import br.com.silvanopessoa.rest.test.util.fixturefactory.extension.CustomRule;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class UsuarioTemplateLoader.
 * 
 * @see https://github.com/six2six/fixture-factory
 */
public class UsuarioTemplateLoader implements TemplateLoader{

	/* (non-Javadoc)
	 * @see br.com.six2six.fixturefactory.loader.TemplateLoader#load()
	 * @see https://github.com/six2six/fixture-factory#managing-templates
	 * 
	 * @see https://github.com/six2six/fixture-factory#regex
	 */
	@Override
	public void load() {
		Fixture.of(Usuario.class).addTemplate("valid", new CustomRule(){{
            add("id", regex("\\w{2,7}@gmail.com"));
            add("dataAlteracao", jodaInstant("today"));
            add("clienteId",random(Long.class, range(1l, 10000000000l)));
            add("enabled", random(Boolean.class));
            add("authorities",has(10).of(SimpleGrantedAuthority.class,"valid"));
        }});
	}

}
