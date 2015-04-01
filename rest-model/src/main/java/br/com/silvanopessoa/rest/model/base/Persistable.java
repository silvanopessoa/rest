package br.com.silvanopessoa.rest.model.base;

import java.io.Serializable;

/**
 * O(a) Interface Persistence.
 *
 * @author silvano.pessoa
 * @since 26/10/2014 - 10:44:12
 */
public interface Persistable<T extends Serializable> extends Serializable {

    /**
     * Obtém o valor do(a)(s) id.
     *
     * @author silvano.pessoa
     * @return the id
     */
    T getId();
    
    /**
     * Verifica se é new.
     *
     * @author silvano.pessoa
     * @return true, se for new
     */
    boolean isNew();
}
