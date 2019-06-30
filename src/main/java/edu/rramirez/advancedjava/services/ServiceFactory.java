package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
	public static StockService getStockServiceInstance() {
		return new DatabaseStockService();
	}
	
	public static PersonService getPersonServiceInstance() {
		return new DatabasePersonService();
	}
}
