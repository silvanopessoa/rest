package br.com.silvanopessoa.rest.api.exception;


// TODO: Auto-generated Javadoc
/**
 * O(a) Class ResourceNotFoundException.
 *
 * @author silvano.pessoa
 * @since 04/03/2015 - 21:24:44
 * 
 * <!-- 04 - INTERCEPTADOR DE EXCEPTION -->
 */
public class ResourceNotFoundException extends RuntimeException{

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new resource not found exception.
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message o(a) message
     * @param cause o(a) cause
     * @param enableSuppression o(a) enable suppression
     * @param writableStackTrace o(a) writable stack trace
     */
    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message o(a) message
     * @param cause o(a) cause
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param message o(a) message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Instantiates a new resource not found exception.
     *
     * @param cause o(a) cause
     */
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
