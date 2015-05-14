package br.com.silvanopessoa.rest.api.type;

public final class RFC2616Type {

    /**
     * Instancia um novo(a) uris.
     */
    private RFC2616Type() {
    }
    
    /** A Constante PRECONDITION_FAILED_ENTITY_SPEC. */
    public static final String UNAUTHORIZED_ENTITY_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.2";

    /** A Constante UNPROCESSABLE_ENTITY_SPEC. */
    public static final String UNPROCESSABLE_ENTITY_SPEC = "http://tools.ietf.org/html/rfc2616#section-10.4.5";

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

    /** A Constante UNPROCESSABLE_ENTITY_URI. */
    public static final String UNPROCESSABLE_ENTITY_URI = "br/com/silvanopessoa/rest/clienterror/business";

    /** A Constante UNPROCESSABLE_ENTITY_INPUT_URI. */
    public static final String UNPROCESSABLE_ENTITY_INPUT_URI = "br/com/silvanopessoa/rest/clienterror/inputvalidation";

    /** A Constante NOT_FOUND_URI. */
    public static final String NOT_FOUND_URI = "br/com/silvanopessoa/rest/clienterror/notfound";
    
    /** A Constante NOT_FOUND_URI. */
    public static final String REQUEST_BINDING_EXCEPTION_URI = "br/com/silvanopessoa/rest/clienterror/parameterInputvalidation";

    /** A Constante NOT_MODIFIED_URI. */
    public static final String NOT_MODIFIED_URI = "br/com/silvanopessoa/rest/redirection/notmodified";

}
