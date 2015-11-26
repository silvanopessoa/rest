/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  26/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.test.util.reflection;

import java.lang.reflect.Field;

import net.vidageek.mirror.dsl.Mirror;

/**
 * The Class ReflectionUtil.
 * 
 * 
 */
public final class ReflectionUtil {

	/**
	 * Instancia um novo(a) reflection util.
	 */
	private ReflectionUtil() {
	}
	
    /**
     * Obtém o valor do(a)(s) field.
     *
     * @param clazz O(a)(s) clazz
     * @param fieldName O(a)(s) field name
     * @return O(a)(s) field
     * 
     * @see 	//http://projetos.vidageek.net/mirror/field/
     */
    public static Field getField(Class<?> clazz,String fieldName) {
        return new Mirror().on(clazz).reflect().field(fieldName);
    }

}
