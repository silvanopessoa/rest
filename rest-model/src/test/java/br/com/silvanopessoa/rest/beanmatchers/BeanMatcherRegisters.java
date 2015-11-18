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
package br.com.silvanopessoa.rest.beanmatchers;

import java.util.Random;

import org.joda.time.DateTime;

import com.google.code.beanmatchers.BeanMatchers;
import com.google.code.beanmatchers.ValueGenerator;

/**
 * The Class BeanMatcherRegisters.
 * 
 * @see https://github.com/orien/bean-matchers#generating-property-values 
 */
public class BeanMatcherRegisters {
	
	{
	    BeanMatchers.registerValueGenerator(new ValueGenerator<DateTime>() {
	        public DateTime generate() {
	        	Random random = new Random();
	            return new DateTime(random.nextLong()).withMillisOfSecond(0);  // Change to generate random instance
	        }
	    }, DateTime.class);
		
	}
	
	/**
	 * Instancia um novo(a) bean matcher registers.
	 */
	private BeanMatcherRegisters(){
	}
	
    /**
     * Load.
     */
    public static void load() {
        new BeanMatcherRegisters();
    }

}
