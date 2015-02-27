package br.com.silvanopessoa.rest.api.base;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.dao.EmptyResultDataAccessException;

public class PreconditionsRest {

    public static <T> T checkNotFound(T reference) {
        if (reference == null) {
            throw new EmptyResultDataAccessException(NOT_FOUND.getReasonPhrase(), 1);
        }
        return reference;
    }

}
