package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.util.DatabaseConnectionException;
import edu.rramirez.advancedjava.util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

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
	public StockQuote getQuote(String symbol) throws StockServiceException {

    
		StockQuote stockQuote = null;

		try {
			Connection connection = DatabaseUtils.getConnection();
			Statement statement = connection.createStatement();
			String queryString = "select symbol, time, price from quotes " +
					             "where time = (select max(time) from quotes where symbol = '" + symbol + "')";

			ResultSet resultSet = statement.executeQuery(queryString);

			if (resultSet.next()) {
				
				String symbolValue = resultSet.getString("symbol");
				Date time = resultSet.getDate("time");
				BigDecimal price = resultSet.getBigDecimal("price");

				stockQuote = new StockQuote(price, time, symbolValue);
			} else {
				throw new StockServiceException("There is no stock data for:" + symbol);
			}

		} catch (DatabaseConnectionException | SQLException exception) {
			throw new StockServiceException(exception.getMessage(), exception);
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
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until)throws StockServiceException {
    	
    	List<StockQuote> stockQuotes = null;
    	
    	//Converting java.util.Date to java.sql.Date
    	Date sqlFrom = new java.sql.Date(from.getTimeInMillis());
    	Date sqlUntil = new java.sql.Date(until.getTimeInMillis());
    	
        try {
        	
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            
            /** This query will return the stock quotes in an between sqlFrom to sqlUntil 
                for a given stock symbol */
            String queryString = "select * from quotes where time between '" + sqlFrom + "' " + 
                                 "and '" + sqlUntil + "' and symbol = '" + symbol + "' " +
            		             "order by time desc";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            
            while(resultSet.next()) {
            	
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(price, time, symbolValue));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
        	
            throw new StockServiceException(exception.getMessage(), exception);
        }
        
        if (stockQuotes.isEmpty()) {
        	
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes;
    }
}
