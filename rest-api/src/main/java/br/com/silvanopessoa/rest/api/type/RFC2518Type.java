/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  18/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.api.type;

public final class RFC2518Type {

	/**
	 * Instancia um novo(a) RFC 2518 type.
	 */
	private RFC2518Type() {
	}

    /** A Constante UNPROCESSABLE_ENTITY_SPEC. */
    public static final String UNPROCESSABLE_ENTITY_SPEC = "http://tools.ietf.org/html/rfc2518#page-60";
    
    /** A Constante UNPROCESSABLE_ENTITY_URI. */
    public static final String UNPROCESSABLE_ENTITY_URI = "br/com/silvanopessoa/rest/clienterror/business";

    /** A Constante UNPROCESSABLE_ENTITY_INPUT_URI. */
    public static final String UNPROCESSABLE_ENTITY_INPUT_URI = "br/com/silvanopessoa/rest/clienterror/inputvalidation";

}
