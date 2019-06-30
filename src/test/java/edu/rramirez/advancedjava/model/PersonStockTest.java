package edu.rramirez.advancedjava.model;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonStock class
 */
public class PersonStockTest {

    /**
     * Testing helper method for generating PersonStock test data
     *
     * @return a PersonStock object that uses Person and StockCompany
     * return from their respective create method.
     */
    public static PersonStock createPersonStock() {
        Person person = PersonTest.createPerson();
        StockCompany stock = StockCompanyTest.createStockCompany();
        return new PersonStock(person, stock);
    }

    @Test
    public void testPersonStockGetterAndSetters() {
        StockCompany stock = StockCompanyTest.createStockCompany();
        Person person = PersonTest.createPerson();
        PersonStock personStock = new PersonStock();
        int id = 10;
        person.setId(id);
        personStock.setId(id);
        personStock.setPerson(person);
        personStock.setStock(stock);
        assertEquals("person matches", person, personStock.getPerson());
        assertEquals("stock matches", stock, personStock.getStock());
        assertEquals("id matches", id, person.getId());
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonStock personStock = createPersonStock();
        personStock.setId(10);
        StockCompany stockCompany = StockCompanyTest.createStockCompany();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonStock personStock2 = new PersonStock(person, stockCompany);
        assertFalse("Different person", personStock.equals(personStock2));
    }

    @Test
    public void testEquals() {
        PersonStock personStock = createPersonStock();
        assertTrue("Same objects are equal", personStock.equals(createPersonStock()));
    }

    @Test
    public void testToString() {
        PersonStock personStock = createPersonStock();
        assertTrue("toString has lastName", personStock.toString().contains(PersonTest.lastName));
        assertTrue("toString has person", personStock.toString().contains(PersonTest.firstName));
        assertTrue("toString has company name", personStock.toString().contains(personStock.getStock().toString()));
        
    }

}
