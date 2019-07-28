package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.StockQuote;
import yahoofinance.histquotes.Interval;

import java.util.Calendar;
import java.util.List;

/**
 * This API describes how to get stock data from an external resource.
 * 
 * @author Ramon Ramirez
 *
 */
public interface StockService {


    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    StockQuote getQuote(String symbol) throws StockServiceException;

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
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException;
    
    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @param interval how often the quotes will be feed it
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, String inteval) 
    		throws StockServiceException;

}

