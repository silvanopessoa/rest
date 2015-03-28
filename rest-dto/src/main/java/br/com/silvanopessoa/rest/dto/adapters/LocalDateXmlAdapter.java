package br.com.silvanopessoa.rest.dto.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.LocalDate;

/**
 * O(a) Class LocalDateXmlAdapter.
 *
 * @author silvano.pessoa
 * @since 28/03/2015 - 15:02:58
 */
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate>{

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public LocalDate unmarshal(String value) throws Exception {
        return LocalDate.parse(value);
    }

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public String marshal(LocalDate value) throws Exception {
        return value.toString();
    }

}
