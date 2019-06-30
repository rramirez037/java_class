package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.model.StockCompany;
import edu.rramirez.advancedjava.model.PersonStock;
import edu.rramirez.advancedjava.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DatabasePersonService implements PersonService {





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
    public List<StockCompany> getStock(Person person) throws PersonServiceException{
    	
    	Session session = DatabaseUtils.getSessionFactory().openSession();
        List<StockCompany> listOfStock = new ArrayList<>();
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
            
            //returnValue = criteria.list();
            List<PersonStock> list = criteria.list();
            
            for(PersonStock stock : list) {
            	listOfStock.add(stock.getStock());
            }
            
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
}
