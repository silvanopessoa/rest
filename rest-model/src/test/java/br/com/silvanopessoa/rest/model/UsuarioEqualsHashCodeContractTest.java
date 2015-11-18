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
package br.com.silvanopessoa.rest.model;

import junitx.extensions.EqualsHashCodeTestCase;

/**
 * The Class UsuarioEqualsHashCodeContractTest.
 */
public class UsuarioEqualsHashCodeContractTest extends EqualsHashCodeTestCase{

	/**
	 * Instancia um novo(a) usuario equals hash code contract test.
	 *
	 * @param name O(a)(s) name
	 */
	public UsuarioEqualsHashCodeContractTest(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junitx.extensions.EqualsHashCodeTestCase#createInstance()
	 */
	@Override
	protected Object createInstance() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId("a@a.com.br");
		return usuario;
	}

	/* (non-Javadoc)
	 * @see junitx.extensions.EqualsHashCodeTestCase#createNotEqualInstance()
	 */
	@Override
	protected Object createNotEqualInstance() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId("b@b.com.br");
		return usuario;
	}
	
}
