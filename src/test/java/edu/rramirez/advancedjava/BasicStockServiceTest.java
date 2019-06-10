package edu.rramirez.advancedjava;

import org.junit.Test;
import org.mockito.Mockito;

import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.stockservice.StockService;
import edu.rramirez.advancedjava.stockservice.StockServiceFactory;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class BasicStockServiceTest {


	/**
     * This methos verifies the current stock price of a given stock symbol
     */
    @Test
    public void stockQuoteTest() {

        /* we want to 'mock' the external dependency which is the   StockService
         * so that we can test just the BasicStockService class.
         */
       StockService stockServiceFactory = StockServiceFactory.getInstance();

        // next create the data we expect the service to return
        String stockSymbol = "APPL";
        BigDecimal expectedPrice = new BigDecimal(200);
        Calendar from = Calendar.getInstance();
        Calendar until = Calendar.getInstance();
        from.add( Calendar.DAY_OF_YEAR, -20);

        
        List<StockQuote> stockQuote = stockServiceFactory.getQuote(stockSymbol, from, until);
        
        assertTrue("There should be 21 days", stockQuote.size() == 21);
        assertTrue("Stock symbol equal APPL", stockSymbol.contentEquals("APPL"));
        

    }
    
    @Test (expected = NullPointerException.class)
    public void testMainNegative() {
    	
    	StockQuoteApp.main(null);
    }
    
    @Test 
    public void testMainPositive() {
    	
    	String[] arguments = {"APPL", "02/20/2019", "02/25/2019"};
    	StockQuoteApp.main( arguments );
    	
    }
}
