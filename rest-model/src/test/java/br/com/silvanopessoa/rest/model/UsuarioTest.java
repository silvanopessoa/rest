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
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.silvanopessoa.rest.test.util.beanmatchers.BeanMatcherRegisters;
import br.com.silvanopessoa.rest.test.util.reflection.ReflectionUtil;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class UsuarioTest.
 */
public class UsuarioTest{

	/**
	 * Setup.
	 * 
	 * @see https://github.com/orien/bean-matchers#generating-property-values
	 * @see https://github.com/six2six/fixture-factory#managing-templates 
	 */
	@BeforeClass
	public static void setup(){
		BeanMatcherRegisters.load();
		FixtureFactoryLoader.loadTemplates("br.com.silvanopessoa.rest.model.template");
	}
	
    /**
     * Load usuario.
     *
     * @param nome O(a)(s) nome
     * @return O(a)(s) usuario
     */
    public static Usuario loadUsuario(String nome) {
        return Fixture.from(Usuario.class).gimme(nome);
    }
    
	/**
	 * Deve_respeitar_contrato_equals_para_os_campos_informados.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-the-equals-method
	 */
	@Test
	public void deve_respeitar_contrato_equals_para_os_campos_informados(){
		assertThat(Usuario.class, hasValidBeanEqualsFor("id"));
	}

	/**
	 * Deve_respeitar_contrato_hashcode_para_os_campos_informados.
	 * 
	 * @see https://github.com/orien/bean-matchers#testing-the-hashcode-method
	 */
	@Test
	public void deve_respeitar_contrato_hashcode_para_os_campos_informados(){
		assertThat(Usuario.class, hasValidBeanHashCodeFor("id"));
	}
	
	/**
	 * Deve_respeitar_contrato_equals_hashcode.
	 * 
	 * @see http://www.jqno.nl/equalsverifier/
	 */
	@Test
	public void deve_respeitar_contrato_equals_hashcode() {
		EqualsVerifier.forClass(Usuario.class).suppress(Warning.STRICT_INHERITANCE).verify();
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
	
	/**
	 * Deve_gerar_um_usuario_valido.
	 * 
	 * @see https://github.com/junit-team/junit/wiki/Assertions
	 */
	@Test
	public void deve_gerar_um_usuario_valido(){
		Usuario usuario = loadUsuario("valid");
		assertNotNull(usuario);
	}
	

	public void deve_(){
		//assertThat(field("clienteId"), not(acceptNull()));
	}
	
	/**
	 * Field.
	 *
	 * @param nome O(a)(s) nome
	 * @return O(a)(s) field
	 */
	public static Field field(String fieldName) {
		return ReflectionUtil.getField(Usuario.class, fieldName);
	}
	

}
