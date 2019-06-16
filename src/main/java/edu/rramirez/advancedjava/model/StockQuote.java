package edu.rramirez.advancedjava.model;

import java.util.Date;

import org.apache.http.annotation.Immutable;

import java.math.BigDecimal;

/**
 * StockQuote class - is a container for information about a stock. This class
 * is immutable.
 *
 * @author Ramon Ramirez
 */
@Immutable 
public class StockQuote {

	private String stockSymbol;
	private BigDecimal stockPrice;
	private Date transactionDate;

	/**
	 * Construct and initializes the instance fields
	 * 
	 * @param StockSymbol     the stock symbol of the company you want a quote for
	 *                        e.g. APPL for APPLE.
	 * @param StockPrice      the stock price for a given company (stock symbol).
	 * @param transactionDate the date when the transaction took place.
	 */
	public StockQuote(String stockSymbol, BigDecimal stockPrice, Date transactionDate) {

		this.stockSymbol = stockSymbol;
		this.stockPrice = stockPrice;
		this.transactionDate = transactionDate;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public BigDecimal getStockPrice() {
		return stockPrice;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	@Override
	public String toString() {

		return "StockQuote{" + "stockSymbol='" + stockSymbol + '\'' + ", stockPrice=" + stockPrice
				+ ", transactionDate=" + transactionDate + '}';
	}
}