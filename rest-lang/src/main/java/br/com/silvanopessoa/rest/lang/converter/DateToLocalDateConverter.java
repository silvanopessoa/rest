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
package br.com.silvanopessoa.rest.lang.converter;

import java.util.Date;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.springframework.core.convert.converter.Converter;

/**
 * The Class DateToLocalDateConverter.
 */
public class DateToLocalDateConverter implements Converter<Date, LocalDate> {

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public LocalDate convert(Date source) {
        if (source == null) {
            return null;
        }
        LocalDateTime dt = LocalDateTime.fromDateFields(source);

        int offset = DateTimeZone.getDefault().getOffsetFromLocal(source.getTime());
        return dt.minusMillis(offset).toLocalDate();
    }
}
