package edu.rramirez.advancedjava.services;

import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.model.PersonStock;
import edu.rramirez.advancedjava.model.PersonTest;
import edu.rramirez.advancedjava.services.PersonService;
import edu.rramirez.advancedjava.services.PersonServiceException;
import edu.rramirez.advancedjava.services.ServiceFactory;
import edu.rramirez.advancedjava.util.DatabaseUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the DatabasePersonService
 */
public class DatabasePersonServiceTest {

    private PersonService personService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    // clean up after ourselves. (this could also restore db from initial state
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    @Test
    public void testGetPerson() throws PersonServiceException {
        List<Person> personList = personService.getPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }


    @Test
    public void testGetStock() throws PersonServiceException{
    	
        Person person = PersonTest.createPerson();
        List<PersonStock> personStock = personService.getStock(person);
       
        // if  hobbyList is empty then we know the lists matched.
        assertTrue("Verify the list of returned stocks match what was expected ", personStock.isEmpty());

    }


}
