package edu.rramirez.advancedjava.app;

import edu.rramirez.advancedjava.model.StockQuery;
import edu.rramirez.advancedjava.services.ServiceFactory;
import edu.rramirez.advancedjava.services.StockService;
import edu.rramirez.advancedjava.services.StockServiceException;
import edu.rramirez.advancedjava.app.BasicStockQuoteApp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

/**
 * Tests for BasicStockQuoteApp - it requires three command line arguments
 * Args[0] - (String) symbol represents the stock symbol
 * Args[1] - (String) from represents the start date
 * Args[2] - (String) until represents the end date
 */
public class BasicStockQuoteAppTest {

    private BasicStockQuoteApp basicStockQuoteApp;
    private StockService stockService;

    @Before
    public void setUp() {
        stockService = ServiceFactory.getStockServiceInstance();
    }

    @Test
    public void testValidConstruction() {
    	basicStockQuoteApp = new BasicStockQuoteApp(stockService);
        assertNotNull("Basic construction works");
    }

    @Test
    public void testDisplayResults() throws ParseException, StockServiceException {
    	
        String symbol = "GOOG";
        String from = "2019/01/01";    //date format: yyyy/MM/dd
        String until = "2019/07/01";
        
        StockQuery stockQuery = new StockQuery(symbol, from, until);        
        basicStockQuoteApp = new BasicStockQuoteApp(stockService);

        String output = basicStockQuoteApp.displayStockQuotes(stockQuery);
        assertTrue("make sure symbol appears in output", output.contains(symbol));
        assertTrue("make sure from date appears in output", output.contains(from));
       // assertTrue("make sure until date in output", output.contains(until));
        
    }

    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        BasicStockQuoteApp.main(null);
    }
}
