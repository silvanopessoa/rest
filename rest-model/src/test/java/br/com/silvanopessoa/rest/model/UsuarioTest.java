/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  18/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *   @see https://github.com/orien/bean-matchers                              *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.model;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersFor;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.silvanopessoa.rest.beanmatchers.BeanMatcherRegisters;

/**
 * The Class UsuarioTest.
 */
public class UsuarioTest{

	/**
	 * Setup.
	 * 
	 * @see @see https://github.com/orien/bean-matchers#generating-property-values 
	 */
	@BeforeClass
	public static void setup(){
		BeanMatcherRegisters.load();
	}
	
	/**
	 * Deve_respeitar_contrato_equals.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-the-equals-method
	 */
	@Test
	public void deve_respeitar_contrato_equals(){
		assertThat(Usuario.class, hasValidBeanEqualsFor("id"));
	}
	
	/**
	 * Deve_respeitar_contrato_hashcode.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-the-hashcode-method
	 */
	@Test
	public void deve_respeitar_contrato_hashcode(){
		assertThat(Usuario.class, hasValidBeanHashCodeFor("id"));
	}
	
	/**
	 * Deve_ter_um_construtor_sem_argumentos.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-the-no-args-constructor
	 */
	@Test
	public void deve_ter_um_construtor_sem_argumentos(){
		assertThat(Usuario.class, hasValidBeanConstructor());
	}
	
	/**
	 * Deve_ter_get_set_para_algumas_propriedades.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-getters-and-setters
	 */
	@Test
	public void deve_ter_get_set_para_algumas_propriedades(){
		assertThat(Usuario.class, hasValidGettersAndSettersFor("clienteId","dataAlteracao","authorities","password"));
	}

}
