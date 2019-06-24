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
public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
	public static StockService getInstance() {
		return new DatabaseStockService() {

			@Override
			public StockQuote getQuote(String symbol) throws StockServiceException {
				return new DatabaseStockService().getQuote(symbol);
			}

			@Override
			public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until)
					throws StockServiceException {
				return new DatabaseStockService().getQuote(symbol, from, until);
			}
		};
	}
}
