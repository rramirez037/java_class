package edu.rramirez.advancedjava;

import org.junit.Test;

import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.stockservice.StockService;
import edu.rramirez.advancedjava.stockservice.StockServiceFactory;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class BasicStockServiceTest {

	/**
	 * This method test for the current stock price of a given stock symbol
	 */
	@Test
	public void oneArgumentTest() {

		StockQuote stockQuote;
		StockService stockService = StockServiceFactory.getInstance();

		String symbol = "APPL";
		BigDecimal expectedPrice = new BigDecimal(10);

		stockQuote = stockService.getQuote(symbol);

		assertTrue("The price should be equal to 10", stockQuote.getStockPrice().compareTo(expectedPrice) == 0);
	}

	/**
	 * This method test when three arguments are provided.
	 */
	@Test
	public void threeArgumentTest() {

		// next create the data we expect the service to return
		String symbol = "APPL";
		Calendar from = Calendar.getInstance();
		Calendar until = Calendar.getInstance();
		StockService stockService = StockServiceFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

		try {

			from.setTime(sdf.parse("01/01/2019"));
			until.setTime(sdf.parse("01/10/2019"));

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid format: mm/dd/yyyy");
		}

		List<StockQuote> list = stockService.getQuote(symbol, from, until);

		// returns one more since it uses an inclusive implementation.
		// example: it will return result from Mon to Mon for a week quote
		assertTrue("The size of the list should be 10 days", list.size() == 10);
		assertTrue("Stock symbol equal APPL", symbol.contentEquals("APPL"));

	}

	@Test
	public void fourArgumentTest() {

		// next create the data we expect the service to return
		String symbol = "APPL";
		Calendar from = Calendar.getInstance();
		Calendar until = Calendar.getInstance();
		StockService stockService = StockServiceFactory.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

		try {

			from.setTime(sdf.parse("01/01/2019"));
			until.setTime(sdf.parse("01/2/2019"));

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid format: mm/dd/yyyy");
		}

		List<StockQuote> list = stockService.getQuote(symbol, from, until, Interval.HOURLY);

		assertTrue("The size of the list should be 25 hours ", list.size() == 25);

		try {

			from.setTime(sdf.parse("01/01/2019"));
			until.setTime(sdf.parse("01/10/2019"));

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid format: mm/dd/yyyy");
		}

		list = stockService.getQuote(symbol, from, until, Interval.DAILY);
		assertTrue("The size of the list should be 10 days", list.size() == 10);

		try {

			from.setTime(sdf.parse("01/01/2019"));
			until.setTime(sdf.parse("01/31/2019"));

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid format: mm/dd/yyyy");
		}
		list = stockService.getQuote(symbol, from, until, Interval.WEEKLY);
		assertTrue("The size of the list should be 4 weeks", list.size() == 5);

		try {

			from.setTime(sdf.parse("01/01/2019"));
			until.setTime(sdf.parse("12/01/2019"));

		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid format: mm/dd/yyyy");
		}
		
		stockService = StockServiceFactory.getInstance();

		list = stockService.getQuote(symbol, from, until, Interval.MONTHLY);
		assertTrue("The size of the list should be 12 months", list.size() == 12);

	}
}
