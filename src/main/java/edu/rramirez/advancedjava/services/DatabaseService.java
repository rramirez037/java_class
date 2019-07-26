package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.model.PersonStock;
import edu.rramirez.advancedjava.model.StockQuote;
import edu.rramirez.advancedjava.util.DatabaseConnectionException;
import edu.rramirez.advancedjava.util.DatabaseUtils;
import edu.rramirez.advancedjava.xml.Stock;

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

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DatabaseService implements StockService, PersonService, XMLService {
	
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
    
    @Override
	public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, String inteval)
			throws StockServiceException {
		// TODO Auto-generated method stub
		return null;
	}
    
    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getPerson() throws PersonServiceException{
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        
        return returnValue;

    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<PersonStock> getStock(Person person) throws PersonServiceException{
    	
    	Session session = DatabaseUtils.getSessionFactory().openSession();
        List<PersonStock> listOfStock = new ArrayList<>();
        Transaction transaction = null;
        
        try {
        	
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(PersonStock.class);
            criteria.add(Restrictions.eq("person", person));

            /**
             * NOTE criteria.list(); generates unchecked warning so SuppressWarnings
             * is used - HOWEVER, this about the only @SuppressWarnings I think it is OK
             * to suppress them - in almost all other cases they should be fixed not suppressed
             */
            
            listOfStock = criteria.list();
            //returnValue = criteria.list();
            //List<PersonStock> list = criteria.list();
            
           // for(PersonStock stock : list) {
            	
           // 	listOfStock.add(stock.getStock());
          //  }
            
            transaction.commit();

        } catch (HibernateException e) {
        	
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            
            throw new PersonServiceException("Could not get Person data. " + e.getMessage(), e);
            
        } finally {
        	
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return listOfStock;
    	
    }
    
    public void saveStock(List<Stock> stocks) throws StockServiceException {

		Session session = DatabaseUtils.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			for (Stock stock : stocks)
				session.save(stock);

		} catch (HibernateException e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback(); // close transaction
			}
			throw new StockServiceException("Could not save the data. " + e.getMessage(), e);
		} finally {
			if (transaction != null && transaction.isActive()) {
				transaction.commit();
			}
		}

		session.close();
	}

}
