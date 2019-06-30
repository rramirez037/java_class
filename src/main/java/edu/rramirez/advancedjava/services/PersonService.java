package edu.rramirez.advancedjava.services;


import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.model.PersonStock;
import java.util.List;

/**
 * This API purpose is to get information regarding a person.
 */
public interface PersonService {

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
	List<Person> getPerson() throws PersonServiceException;
	
	/**
	 * /**
     * Get a list of stock for the provided person
     *
	 * @param person The person to get the list of stocks from
	 * 
	 * @return a list of stock instances
	 * 
	 * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
	 */
	List<PersonStock> getStock(Person person) throws PersonServiceException;
	
}
