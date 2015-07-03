/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  05/06/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Classe base para Entidades.
 * 
 * @author silvano.pessoa
 * 
 * @param <T>
 */
@MappedSuperclass
public abstract class AbstractPersistable<T extends Serializable> implements Persistable<T> {

    /**
     * SERIAL VERSION UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * CODIGO 17 GERADO PELO SPRING DATA
     */
    private static final int HASHCODE17_SPRING = 17;

    /**
     * CODIGO 31 GERADO PELO SPRING DATA
     */
    private static final int HASHCODE31_SPRING = 31;

    /**
     * Identificador
     * 
     */
    @Id
    @Column(nullable = false)
    private T id;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.domain.Persistable#getId()
     */
    @Override
    @XmlTransient
    public T getId() {
        return id;
    }

    /**
     * Sets the id of the entity.
     * 
     * @param id the id to set
     */
    public void setId(final T id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.domain.Persistable#isNew()
     */
    @Override
    public boolean isNew() {
        return null == getId();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, new JsonToStringStyle());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().equals(obj.getClass())) {
            return false;
        }
        AbstractPersistable<?> that = (AbstractPersistable<?>) obj;
        return null == this.getId() ? false : this.getId().equals(that.getId());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hashCode = HASHCODE17_SPRING;
        hashCode += null == getId() ? 0 : getId().hashCode() * HASHCODE31_SPRING;
        return hashCode;
    }

}
