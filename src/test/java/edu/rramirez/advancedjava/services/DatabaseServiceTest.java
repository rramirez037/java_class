package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.StockQuery;
import edu.rramirez.advancedjava.model.StockQuote;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the DatabaseService
 */
public class DatabaseServiceTest {

    @Test
    public void testGetQuote() throws StockServiceException {
        DatabaseService DatabaseService = new DatabaseService();
        String symbol = "APPL";
        StockQuote stockQuote = DatabaseService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }
    
    @Test
    public void testGetQouteII() throws ParseException, StockServiceException {
    	
    	DatabaseService DatabaseService = new DatabaseService();
    	List<StockQuote> stockQuotes = new ArrayList<>();
    	
    	try {
    		
    		StockQuery stockQuery = new StockQuery( "GOOG", "2012/01/01", "2018/01/01");
    		stockQuotes = DatabaseService.getQuote(stockQuery.getSymbol(), stockQuery.getFrom(), stockQuery.getUntil());
    		
    		//This will vary depending on the removal or insertion of new data
    		//assertTrue( "The list should have 6 StockQuote", stockQuotes.size() == 6);
    		 
    	} catch(ParseException | StockServiceException e){
    		
    		throw new StockServiceException(e.getMessage(), e);
    	}
    }
}
