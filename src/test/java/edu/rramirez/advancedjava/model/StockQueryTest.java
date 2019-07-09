package edu.rramirez.advancedjava.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {

    @Test
    public void testBasicConstruction() throws Exception{
    	
    	Calendar calendar = new GregorianCalendar();
    	
        String symbol = "APPL";
        StockQuery stockQuery = new StockQuery(symbol,"2010/11/11","2011/11/11");
        assertEquals("Verify the symbol construction", symbol, stockQuery.getSymbol());
        assertEquals("Verify the from construction", calendar.getClass(), stockQuery.getFrom().getClass());
        assertEquals("Verify the until construction", calendar.getClass(), stockQuery.getUntil().getClass());
    }
    
    @Test(expected = ParseException.class)
    public void NegativeStockQueryTest() throws ParseException {
    	
    	String symbol = "APPL";
    	
    	try {
    		
        new StockQuery(symbol,"date","2011/11/11");
        
    	} catch( ParseException e) {
    		throw new ParseException(e.getMessage(), 0 );
    	}
    }

}
