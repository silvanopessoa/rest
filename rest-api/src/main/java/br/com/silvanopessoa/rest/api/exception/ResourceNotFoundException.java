package br.com.silvanopessoa.rest.api.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * O(a) Class ResourceNotFoundException.
 *
 * @author silvano.pessoa
 * @since 04/03/2015 - 21:24:44
 */
@ResponseStatus(value=NOT_FOUND) 
public class ResourceNotFoundException extends RuntimeException{

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

}
