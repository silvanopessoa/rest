/**
 * 
 */
package br.com.silvanopessoa.rest.dto.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

/**
 * O(a) Class DateTimeXmlAdapter.
 * 
 * https://weblogs.java.net/blog/kohsuke/archive/2005/09/using_jaxb_20s.html
 *
 * @author silvano.pessoa
 */
public class DateTimeXmlAdapter extends XmlAdapter<String, DateTime> {

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public DateTime unmarshal(String value) throws Exception {
        return DateTime.parse(value);
    }

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public String marshal(DateTime value) throws Exception {
        return value.toString();
    }

}
