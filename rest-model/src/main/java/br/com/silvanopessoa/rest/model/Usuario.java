package br.com.silvanopessoa.rest.model;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import br.com.silvanopessoa.rest.model.base.AbstractPersistable;

/**
 * O(a) Class Usuario.
 *
 * @author silvano.pessoa
 * @since 28/10/2014 - 21:31:26
 */
@Entity
public class Usuario extends AbstractPersistable<String> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a) data alteracao. */
    private DateTime dataAlteracao;

    /**
     * Obtém o valor do(a)(s) data alteracao.
     *
     * @author silvano.pessoa
     * @return o(a) data alteracao
     */
    public DateTime getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * Determina o(a) data alteracao.
     *
     * @author silvano.pessoa
     * @param dataAlteracao
     *            o(a) novo(a) data alteracao
     */
    public void setDataAlteracao(DateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

}
