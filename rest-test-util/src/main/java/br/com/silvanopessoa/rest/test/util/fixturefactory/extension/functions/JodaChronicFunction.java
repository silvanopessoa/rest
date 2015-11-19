/******************************************************************************
 * Produto: REST                                                              *
 *                                                                            *
 *    History:                                                                *
 *          Data        Programador              Tarefa                       *
 *          ----------  -----------------        -----------------------------*
 *   Autor  19/11/2015  silvano.pessoa          Classe criada.                *
 *                                                                            *
 *   Comments:                                                                *
 *                                                                            *
 *                                                                            *
 *****************************************************************************/
package br.com.silvanopessoa.rest.test.util.fixturefactory.extension.functions;

import org.joda.time.DateTime;

import com.mdimension.jchronic.Chronic;
import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.utils.Span;

import br.com.six2six.fixturefactory.function.AtomicFunction;

/**
 * The Class JodaChronicFunction.
 */
public class JodaChronicFunction  implements AtomicFunction {

    /** O(a)(s) date text. */
    private String dateText;
    
    /** O(a)(s) options. */
    private Options options;
    
    /** O(a)(s) is local date. */
    private boolean isLocalDate;
    
    /**
     * Instancia um novo(a) joda chronic function.
     *
     * @param text O(a)(s) text
     * @param localDate O(a)(s) local date
     */
    public JodaChronicFunction(String text, boolean localDate) {
        this(text);
        this.isLocalDate = localDate;
    }
    
    /**
     * Instancia um novo(a) joda chronic function.
     *
     * @param text O(a)(s) text
     */
    public JodaChronicFunction(String text) {
        this.dateText = text;
        this.options = new Options();
    }
    
    /**
     * Instancia um novo(a) joda chronic function.
     *
     * @param text O(a)(s) text
     * @param options O(a)(s) options
     */
    public JodaChronicFunction(String text, Options options) {
        this.dateText = text;
        this.options = options;
    }
    
	/* (non-Javadoc)
	 * @see br.com.six2six.fixturefactory.function.AtomicFunction#generateValue()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T generateValue() {
        Span span = Chronic.parse(dateText, options);
        if (span != null){
            DateTime dateTime = new DateTime(span.getBeginCalendar().getTimeInMillis());
            return (T) (isLocalDate ? dateTime.toLocalDate() : dateTime); 
        }else{
            return null;
        }
	}

}
