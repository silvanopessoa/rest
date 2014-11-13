package br.com.silvanopessoa.rest.api.model;

import javax.persistence.Entity;

import org.joda.time.DateTime;

import br.com.silvanopessoa.rest.api.model.base.AbstractPersistable;

/**
 * O(a) Class Usuario.
 *
 * @author silvano.pessoa
 * @since 28/10/2014 - 21:31:26
 */
@Entity
public class Usuario extends AbstractPersistable<Long> {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** O(a) login. */
    private String login;

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

    /**
     * Obtém o valor do(a)(s) login.
     *
     * @author silvano.pessoa
     * @return o(a) login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Determina o(a) login.
     *
     * @author silvano.pessoa
     * @param login
     *            o(a) novo(a) login
     */
    public void setLogin(String login) {
        this.login = login;
    }

}
