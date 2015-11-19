/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  18/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.test.util.fixturefactory.extension;

import br.com.silvanopessoa.rest.test.util.fixturefactory.extension.functions.JodaChronicFunction;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.function.Function;

/**
 * The Class CustomRule.
 */
public class CustomRule extends Rule{

	/**
	 * Instancia um novo(a) custom rule.
	 */
	public CustomRule() {
		super();
	}
	
    /**
     * Joda instant.
     *
     * @param dateText O(a)(s) date text
     * @return O(a)(s) function
     */
    public Function jodaInstant(String dateText) {
        return new JodaChronicFunction(dateText);
    }
}
