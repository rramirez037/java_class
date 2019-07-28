package edu.rramirez.advancedjava.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StockTest {

	private Integer id;
    private String symbol;
    private String price;
    private String time;
    
    Stock stock = new Stock();

    @Before
    public void setUp() {
        id = new Integer(100);
        symbol = "GOOG";
        price = "230";
        time = "2008-02-13";
        
        stock.setId(id);
        stock.setPrice(price);
        stock.setSymbol(symbol);
        stock.setTime(time);
    }
	
	@Test
	public void testGetterAndSetter() {
		assertEquals("Id is correct", id, stock.getId());
		assertEquals("symbol is correct", symbol, stock.getSymbol());
		assertEquals("price is correct", price, stock.getPrice());
		assertEquals("time is correct", time, stock.getTime());
	}

}
