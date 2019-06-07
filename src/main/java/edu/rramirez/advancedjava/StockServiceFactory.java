package edu.rramirez.advancedjava;
import java.math.BigDecimal;

/**
 * StockServiceFactory class
 * This class return a BasicStockService instance
 *
 */
 
 public class StockServiceFactory implements StockService{
	 
	 public StockQuote getQuote( String symbol ){
		 
		 return new StockQuote( symbol, new BigDecimal(100));
	 }
	 
 }