package br.com.silvanopessoa.rest.api.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * O(a) Class GlobalExceptionHandlingControllerAdvice.
 *
 * @author silvano.pessoa
 * @since 04/03/2015 - 23:06:07
 * 
 * <!-- 04 - INTERCEPTADOR DE EXCEPTION -->
 * 
 * REF: https://github.com/paulc4/mvc-exceptions/blob/master/src/main/java/demo2/web/GlobalExceptionHandlingControllerAdvice.java
 */
@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {

    /**
     * Instantiates a new global exception handling controller advice.
     */
    public GlobalExceptionHandlingControllerAdvice() {
    }
    
    /**
     * Not found.
     *
     * @return the string
     */
    @ResponseBody()
    @ResponseStatus(value=NOT_FOUND) 
    @ExceptionHandler(ResourceNotFoundException.class)
    public void notFound(){
    }
}
