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
	 */
	@Override
	public void load() {
		Fixture.of(Usuario.class).addTemplate("valid", new CustomRule(){{
            add("id", random(String.class, regex("\\w{2,7}@gmail.com")));
            add("dataAlteracao", jodaInstant("today"));
        }});
	}

}
