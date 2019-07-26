package edu.rramirez.advancedjava.services;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import org.junit.Test;

import edu.rramirez.advancedjava.model.StockQuery;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 * Tests the StockAdapterService class
 * 
 * @author Ramon Ramirez
 *
 */
public class StockAdapterServiceTest {

	/**
	 * 
	 * @throws IOException for a connection error
	 */
	@Test
	public void testGetQuote() throws IOException {
		
		    Stock stock = YahooFinance.get("GOOG");
			
		    assertTrue( "Symbol equal GOOG ", stock.getSymbol().equals("GOOG"));
	}
	
	/**
	 * 
	 * @throws IOException for a connection error
	 * @throws ParseException if the dates are in the wrong format
	 */
	@Test
	public void testGetQuotes() throws IOException, ParseException {
		
		StockQuery stockQuery = new StockQuery("GOOG", "2018/01/01", "2018/12/31");
		String symbol  = stockQuery.getSymbol();
		Calendar from  = stockQuery.getFrom();
		Calendar until = stockQuery.getUntil();
		
		Stock stock = YahooFinance.get(symbol, from, until);
		
		assertTrue( "There should be 12 quotes ", stock.getHistory().size() == 12 );
	}

}
