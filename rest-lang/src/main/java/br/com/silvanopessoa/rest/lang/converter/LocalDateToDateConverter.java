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
import org.joda.time.LocalTime;
import org.springframework.core.convert.converter.Converter;

/**
 * The Class LocalDateToDateConverter.
 */
public class LocalDateToDateConverter implements Converter<LocalDate, Date> {

    /* (non-Javadoc)
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Date convert(LocalDate source) {
        if (source == null) {
            return null;
        }
        LocalDateTime dt = source.toLocalDateTime(LocalTime.MIDNIGHT);
        int offset = DateTimeZone.getDefault().getOffsetFromLocal(source.toDateTimeAtStartOfDay().getMillis());
        return dt.plusMillis(offset).toDate();
    }
}
