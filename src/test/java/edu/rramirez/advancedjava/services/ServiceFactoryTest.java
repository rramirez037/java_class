package edu.rramirez.advancedjava.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class ServiceFactoryTest {

    @Test
    public void testGetInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }
}
