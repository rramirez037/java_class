package edu.rramirez.advancedjava;
import java.math.BigDecimal;

/**
 * BasicStockService class
 * This class contains information about a stock.
 */
 
 public class BasicStockService {
	 
	 //BasicStockServiceFactory instance
	 private StockService stockServiceFactory;
	 
	 
	 /**
     *  Create a new  BasicStockService instance
     * @param stockService the stock info 
     * 
     */
	 public BasicStockService( StockService stockService ){
		 this.stockServiceFactory = stockService;
	 }
	 
	 /**
     *  
     * @param stockPrice the price of the stock
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     */
	 public StockQuote getStockPrice( String stockSymbol, BigDecimal stockPrice ){
		 
		 return stockServiceFactory.getQuote( stockSymbol );
		 
	 }
 }