package edu.rramirez.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import edu.rramirez.advancedjava.stockservice.StockService;
import edu.rramirez.advancedjava.stockservice.StockServiceFactory;
import edu.rramirez.advancedjava.model.StockQuote;

public class StockQuoteApp {

	public static void main(String[] args) {

		if (args.length != 3) {
			throw new IllegalArgumentException("Please call program with three arguments");
		}

		// creating calendar object
		Calendar from = Calendar.getInstance();
		Calendar until = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);

		try {
			from.setTime(sdf.parse(args[1]));
			until.setTime(sdf.parse(args[2]));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Please provide date in the format: mm/dd/yyyy");
		}

		StockService stockService = StockServiceFactory.getInstance();
		List<StockQuote> list = new ArrayList<StockQuote>();
		list = stockService.getQuote("APPL", from, until);

		for (StockQuote value : list)
			System.out.println(value);
	}

}
