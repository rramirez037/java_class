package edu.rramirez.advancedjava.stockservice;

import edu.rramirez.advancedjava.model.StockQuote;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;


/**
 *
 */
class BasicStockService implements StockService{
	 
	 @Override
	 public StockQuote getQuote( String symbol ){
		 
		 return new StockQuote( symbol, new BigDecimal(10), Calendar.getInstance().getTime() );
	 }

	@Override
	public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {
		// TODO Auto-generated method stub
		return null;
	}
 }