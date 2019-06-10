package edu.rramirez.advancedjava.stockservice;

import edu.rramirez.advancedjava.model.StockQuote;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * BasicStockService class - returns one or more StockQuote instance.
 * 
 * @author Ramon Ramirez
 *
 */
class BasicStockService implements StockService {

	/**
	 *
	 * @param symbol the stock symbol to search for
	 * 
	 * @return a StockQuote instance
	 */
	@Override
	public StockQuote getQuote(String symbol) {

		return new StockQuote(symbol, new BigDecimal(10), Calendar.getInstance().getTime());
	}

	/**
	 * 
	 * @param symbol the stock symbol to search for      
	 * @param from the date of the first stock quote
	 * @param until the date of the last stock quote
	 * 
	 * @return a list of StockQuote instances
	 */
	@Override
	public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

		List<StockQuote> resultList = new ArrayList<StockQuote>();

		while (from.compareTo(until) <= 0) {

			resultList.add(new StockQuote(symbol, new BigDecimal(10), from.getTime()));
			from.add(Calendar.DAY_OF_YEAR, 1);
		}

		return resultList;
	}
}