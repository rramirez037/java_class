package edu.rramirez.advancedjava;

import org.junit.Test;

public class MainTest {

	@Test(expected = NullPointerException.class)
	public void testMainNegative() {

		StockQuoteApp.main(null);
	}

	@Test
	public void testMainPositive() {

		String[] arguments = { "APPL", "02/20/2019", "02/25/2019" };
		StockQuoteApp.main(arguments);

	}

}
