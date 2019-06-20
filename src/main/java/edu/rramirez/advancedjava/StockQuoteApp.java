package edu.rramirez.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotNull;

import edu.rramirez.advancedjava.stockservice.StockService;
import edu.rramirez.advancedjava.stockservice.StockServiceFactory;
import edu.rramirez.advancedjava.model.StockQuote;

public class StockQuoteApp {

	@NotNull
	public static void main(String[] args) {

		StockService stockService = StockServiceFactory.getInstance();
		StockQuote stockQuote;
		String symbol;
		Calendar from = Calendar.getInstance();
		Calendar until = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		List<StockQuote> list = new ArrayList<StockQuote>();

		switch (args.length) {
		case 1:

			stockQuote = stockService.getQuote(args[0]);
			System.out.println(stockQuote);

			break;

		case 3:

			symbol = args[0];

			try {

				from.setTime(sdf.parse(args[1]));
				until.setTime(sdf.parse(args[2]));

			} catch (ParseException e) {
				throw new IllegalArgumentException("Please provide date in the format: mm/dd/yyyy");
			}

			list = stockService.getQuote(symbol, from, until);

			for (StockQuote value : list)
				System.out.println(value);

			break;

		case 4:

			symbol = args[0];

			try {

				from.setTime(sdf.parse(args[1]));
				until.setTime(sdf.parse(args[2]));

			} catch (ParseException e) {
				throw new IllegalArgumentException("Please provide date in the format: mm/dd/yyyy");
			}

			if (args[3].equalsIgnoreCase("hourly"))
				list = stockService.getQuote(symbol, from, until, Interval.HOURLY);
			else if (args[3].equalsIgnoreCase("daily"))
				list = stockService.getQuote(symbol, from, until);
			else if (args[3].equalsIgnoreCase("weekly"))
				list = stockService.getQuote(symbol, from, until, Interval.WEEKLY);
			else if (args[3].equalsIgnoreCase("monthly"))
				list = stockService.getQuote(symbol, from, until, Interval.MONTHLY);
			else
				throw new IllegalArgumentException("Invalid interval argument: Enter hourly, daily, weekly or monthly");

			System.out.println("SIZE " + list.size());

			for (StockQuote value : list)
				System.out.println(value);

			break;

		default:
			throw new IllegalArgumentException(
					"Invalid number of argument(s), call the program with one, three or four arguments\n"
							+ "StockQuote symbol <from until> <interval>");

		}
	}
}
