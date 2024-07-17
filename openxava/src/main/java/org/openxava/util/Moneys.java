package org.openxava.util;

import java.text.*;
import java.util.*;

import org.openxava.annotations.*;
import org.openxava.model.meta.*;

/**
 * tmr En changelog
 * Utility class to work with money values and properties. 
 * 
 * @since 7.4
 * @author Javier Paniza
 */
public class Moneys {
	
	public static boolean isCurrencySymbolAtStart(Locale locale) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        String formattedCurrency = currencyFormat.format(1);
        String currencySymbol = currencyFormat.getCurrency().getSymbol(locale);
        return !formattedCurrency.endsWith(currencySymbol);
	}
	
	public static boolean isCurrencySymbolAtStart() {
        return isCurrencySymbolAtStart(Locale.getDefault()); // Locale from server, not from browser
	}	

	public static String getCurrencySymbol(Locale locale) { 
		try {
			return Currency.getInstance(locale).getSymbol(locale); 
		}
		catch (Exception ex) { // Because locale may not contain the country
			return "?";
		}
	}
	
	/** From the JVM locale, not from browser. */
	public static String getCurrencySymbol() { 
		return getCurrencySymbol(Locale.getDefault()); // Locale from server, not from browser
	}
	
	public static boolean isMoneyProperty(MetaProperty property) {
		if ("MONEY".equals(property.getStereotype())) return true;
		if ("DINERO".equals(property.getStereotype())) return true;
		return Arrays.stream(property.getAnnotations()).anyMatch(annotation -> annotation instanceof Money);
	}

}
