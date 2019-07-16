package edu.rramirez.advancedjava.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import edu.rramirez.advancedjava.model.StockQuote;

/**
 * This API get live data from Yahoo web service of a given stock symbol
 * 
 * @author Ramon Ramirez
 *
 */
public class StockAdapterService implements StockService{

	/**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>StockQuote</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
	public StockQuote getQuote(String symbol) throws StockServiceException{
	
	  
		StockQuote stockQuote = null;
		
		try{
		
		    Stock stock = YahooFinance.get(symbol);
			
			BigDecimal price = stock.getQuote().getPrice();
			Date date = stock.getQuote().getLastTradeTime().getTime();
			
			stockQuote = new StockQuote( price, date, symbol );
		
		} catch( java.io.IOException e){
		
		    throw new StockServiceException( this.getClass() + " : " + e.getMessage(), e );
		    
	    }
	
	    return stockQuote;
	
	}
	
    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
	public List<StockQuote> getQuote( String symbol, Calendar from, Calendar until ) throws StockServiceException{
	
	    List<StockQuote> stockQuotes = new ArrayList<StockQuote>();
	    
		try{
		
		    BigDecimal price;
		    Date date;
		
		    Stock stock = YahooFinance.get( symbol, from, until );
			 
			for( HistoricalQuote interator : stock.getHistory() ){
			
			    price = interator.getClose();
				date =  interator.getDate().getTime();
				
				stockQuotes.add( new StockQuote( price, date, symbol ) );
			}
		
		}catch( java.io.IOException e){
		
		    throw new StockServiceException( this.getClass() + " : " + e.getMessage(), e );
		
		}
	
	    return stockQuotes;
	}
}

