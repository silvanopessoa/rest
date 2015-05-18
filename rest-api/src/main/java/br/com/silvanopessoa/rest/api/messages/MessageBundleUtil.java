package br.com.silvanopessoa.rest.api.messages;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageBundleUtil {

    @Autowired
    private ResourceBundleMessageSource msg;
    
    /** A Constante PT_BR. */
    public static final String PT_BR = "pt_BR";

    
	public final String getMessage(String code, Object[] args){
		return msg.getMessage(code,args,new Locale(PT_BR));
	}
	
	public final String getMessage(String code){
		return msg.getMessage(code,new Object[] {},new Locale(PT_BR));
	}
}
