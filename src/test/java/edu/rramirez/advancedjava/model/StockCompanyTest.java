package edu.rramirez.advancedjava.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for StockCompany class
 */
public class StockCompanyTest {

    final static String symbol = "GOOG";
    final static String name = "GOOGLE INC";

    /**
     * Testing helper method for generating test data
     *
     * @return a StockCompany object that uses static constants for data.
     */
    public static StockCompany createStockCompany() {
    	
        StockCompany stockCompany = new StockCompany();
        stockCompany.setSymbol(symbol);
        stockCompany.setCompanyName(name);
        
        return stockCompany;
    }

    @Test
    public void testSettersAndGetters() {
    	
    	StockCompany stockCompany = createStockCompany();
    	
        assertEquals("Symbol", symbol, stockCompany.getSymbol());
        assertEquals("Company name", name, stockCompany.getCompanyName());

    }

}
