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
package br.com.silvanopessoa.rest.lang.type;

/**
 * The Class RFC2616Type.
 */
public final class RFC2616Type {

    /**
     * Instancia um novo(a) RFC 2616 type.
     */
    private RFC2616Type() {
    }
    
    /** A Constante PRECONDITION_FAILED_ENTITY_SPEC. */
    public static final String UNAUTHORIZED_ENTITY_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.2";

    /** A Constante CONFLICT_SPEC. */
    public static final String CONFLICT_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.10";

    /** A Constante NOT_FOUND_SPEC. */
    public static final String NOT_FOUND_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.5";

    /** A Constante NOT_MODIFIED_SPEC. */
    public static final String NOT_MODIFIED_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.3.5";
    
    /** The Constant BAD_RESQUEST_SPEC. */
    public static final String BAD_RESQUEST_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.1";

    /** A Constante CONFLICT_URI. */
    public static final String CONFLICT_URI = "br/com/silvanopessoa/rest/clienterror/conflict";

      /** A Constante NOT_FOUND_URI. */
    public static final String NOT_FOUND_URI = "br/com/silvanopessoa/rest/clienterror/notfound";
    
    /** A Constante NOT_FOUND_URI. */
    public static final String REQUEST_BINDING_EXCEPTION_URI = "br/com/silvanopessoa/rest/clienterror/parameterInputvalidation";

    /** A Constante NOT_MODIFIED_URI. */
    public static final String NOT_MODIFIED_URI = "br/com/silvanopessoa/rest/redirection/notmodified";
    
    /** A Constante UNSUPPORTED_MEDIA_TYPE. */
    public static final String UNSUPPORTED_MEDIA_TYPE_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.16";
    
    /** A Constante UNSUPPORTED_MEDIA_TYPE_URI. */
    public static final String UNSUPPORTED_MEDIA_TYPE_URI = "br/com/silvanopessoa/rest/clienterror/unsupportedmediatype";

}
