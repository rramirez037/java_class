package edu.rramirez.advancedjava;

import org.junit.Test;
import org.mockito.Mockito;

import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.stockservice.BasicStockService;
import edu.rramirez.advancedjava.stockservice.StockService;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


public class BasicStockServiceTest {


    /**
     * This methos verifies the current stock price of a given stock symbol
     */
    @Test
    public void getStockPriceTest() {

        /* we want to 'mock' the external dependency which is the   StockService
         * so that we can test just the BasicStockService class.
         */
       StockService stockServiceMock = Mockito.mock(StockService.class);

        // next create the data we expect the service to return
        String stockSymbol = "APPL";
        BigDecimal expectedPrice = new BigDecimal(200);

        // tell the mock service to return the data the getQuote() method is called with a specific symbol
		when(stockServiceMock.getQuote(any(String.class))).thenReturn(new StockQuote(stockSymbol, expectedPrice));

        // now create the BasicStockService instance to test
        BasicStockService basicStockService = new BasicStockService(stockServiceMock);

        // now execute the method we want to test
        BigDecimal stockPriceResult = basicStockService.getStockPrice(stockSymbol, expectedPrice).getStockPrice();

        // now verify that it returned the expected results.
        assertTrue("stockPriceResult should be equal to expectedPrice", stockPriceResult == expectedPrice);

    }
}
