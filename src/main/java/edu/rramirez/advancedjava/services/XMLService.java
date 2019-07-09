package edu.rramirez.advancedjava.services;

import java.util.List;

import edu.rramirez.advancedjava.xml.Stock;

/**
 * This API describes how to save stock data to the mapped table in a database.
 */
public interface XMLService {

	
	/**
	 * Storage stock data into a database
	 * 
	 * @param stocks a list of Stock instances
	 */
	void saveStock( List<Stock> stocks) throws StockServiceException;
}
