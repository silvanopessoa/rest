package br.com.silvanopessoa.rest.api.base;

import br.com.silvanopessoa.rest.api.exception.ResourceNotFoundException;
import cz.jirutka.spring.exhandler.messages.ErrorMessage;

/**
 * O(a) Class PreconditionsRest.
 *
 * @author silvano.pessoa
 * @since 26/02/2015 - 22:39:11
 */
public class PreconditionsRest {

    /**
     * Check not found.
     *
     * @param <T> the generic type
     * @param reference o(a) reference
     * @return the t
     */
    public static <T> T checkNotFound(T reference) {
        if (reference == null) {
            throw new ResourceNotFoundException();
        }
        return reference;
    }

    public static <T> T checkNotFound(T reference, ErrorMessage message) {
        if (reference == null) {
            throw new ResourceNotFoundException(message);
        }
        return reference;
    }
}
