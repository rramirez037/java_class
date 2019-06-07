package edu.rramirez.advancedjava;
import java.math.BigDecimal;

/**
 * StockQuote class
 * A stock container
 */
 public class StockQuote{
	 
	 private String stockSymbol;
	 private BigDecimal stockPrice;
	 
	 public StockQuote( String stockSymbol, BigDecimal stockPrice ){
		 
		 this.stockSymbol = stockSymbol;
		 this.stockPrice = stockPrice;
		 
	 }
	 
	 public String getStockSymbol(){ return stockSymbol; }
	 public BigDecimal getStockPrice(){ return stockPrice; }
	 
 }