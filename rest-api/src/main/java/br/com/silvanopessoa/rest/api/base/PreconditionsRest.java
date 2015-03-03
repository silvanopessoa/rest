package br.com.silvanopessoa.rest.api.base;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.dao.EmptyResultDataAccessException;

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
            throw new EmptyResultDataAccessException(NOT_FOUND.getReasonPhrase(), 1);
        }
        return reference;
    }

}
