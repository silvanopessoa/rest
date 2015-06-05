/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  25/05/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.lang.base;

import java.util.Collection;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.ReadableDateTime;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class JsonToStringStyle extends ToStringStyle {

    /** A Constante serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** A Constante QUOTES. */
    private static final String QUOTES = "\"";

    /** O(a)(s) field name prefix. */
    private String fieldNamePrefix;

    /** O(a)(s) field name suffix. */
    private String fieldNameSuffix;

    /**
     * Instancia um novo(a) json to string style.
     */
    public JsonToStringStyle() {
        setUseClassName(false);
        setUseIdentityHashCode(false);
        setContentStart("{");
        setContentEnd("}");
        setArrayStart("[");
        setArrayEnd("]");
        setFieldSeparator(",");
        setFieldNameValueSeparator(":");
        setNullText("null");
        setFieldNamePrefix(QUOTES);
        setFieldNameSuffix(QUOTES);
    }

    /**
     * Obtém o valor do(a)(s) field name prefix.
     * 
     * @return O(a)(s) field name prefix
     */
    public String getFieldNamePrefix() {
        return fieldNamePrefix;
    }

    /**
     * Define o valor do(a)(s) field name prefix.
     * 
     * @param fieldNamePrefix o novo valor do(a)(s) field name prefix
     */
    public void setFieldNamePrefix(String fieldNamePrefix) {
        this.fieldNamePrefix = defaultString(fieldNamePrefix, "");
    }

    /**
     * Obtém o valor do(a)(s) field name suffix.
     * 
     * @return O(a)(s) field name suffix
     */
    public String getFieldNameSuffix() {
        return fieldNameSuffix;
    }

    /**
     * Define o valor do(a)(s) field name suffix.
     * 
     * @param fieldNameSuffix o novo valor do(a)(s) field name suffix
     */
    public void setFieldNameSuffix(String fieldNameSuffix) {
        this.fieldNameSuffix = defaultString(fieldNameSuffix, "");
    }

    /**
     * Decorate field name.
     * 
     * @param fieldName O(a)(s) field name
     * @return O(a)(s) string
     */
    private String decorateFieldName(String fieldName) {
        return getFieldNamePrefix() + fieldName + getFieldNameSuffix();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.lang3.builder.ToStringStyle#appendFieldStart(java.lang.StringBuffer, java.lang.String)
     */
    @Override
    protected void appendFieldStart(StringBuffer buffer, String fieldName) {
        super.appendFieldStart(buffer, decorateFieldName(fieldName));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.apache.commons.lang3.builder.ToStringStyle#appendDetail(java.lang.StringBuffer, java.lang.String, java.lang.Object)
     */
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {

        if (value == null) {
            appendNullText(buffer, fieldName);
            return;
        }
        if (value instanceof String || value instanceof ReadableDateTime || value instanceof Enum) {
            appendValueAsString(buffer, value);
            return;
        }
        buffer.append(value);
    }

    /* (non-Javadoc)
     * @see org.apache.commons.lang3.builder.ToStringStyle#appendDetail(java.lang.StringBuffer, java.lang.String, java.util.Collection)
     */
    @Override
    protected void appendDetail(StringBuffer buffer, String fieldName, Collection<?> coll) {
        appendDetail(buffer, fieldName, coll.toArray());
    }

    /**
     * Append value as string.
     * 
     * @param buffer O(a)(s) buffer
     * @param value O(a)(s) value
     */
    private void appendValueAsString(StringBuffer buffer, Object value) {
        buffer.append(QUOTES + value.toString() + QUOTES);
    }

}
