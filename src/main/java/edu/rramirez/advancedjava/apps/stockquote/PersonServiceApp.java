package edu.rramirez.advancedjava.apps.stockquote;

import java.util.List;
import java.util.ArrayList;

import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.model.PersonStock;
import edu.rramirez.advancedjava.model.StockCompany;
import edu.rramirez.advancedjava.services.PersonService;
import edu.rramirez.advancedjava.services.PersonServiceException;
import edu.rramirez.advancedjava.services.ServiceFactory;

/**
 * A simple application to show the PersonService in action
 * 
 * @author Ramon Ramirez
 *
 */
public class PersonServiceApp {

	/**
	 * Main doesn't requires any arguments
	 * 
	 * @param args is currently null
	 */
	public static void main(String[] args) {

		PersonService service = ServiceFactory.getPersonServiceInstance();

		Person person = null;
		List<Person> listOfPerson = null;                          //will hold information regarding person
		List<PersonStock> listOfStock = null;                      //will hold information regarding person and stock of interest
		List<StockCompany> listOfStockCompany = new ArrayList<>(); //will hold information regarding stock company

		try {

			listOfPerson = service.getPerson();
			person = listOfPerson.get(2);

			listOfStock = service.getStock(person);

		} catch (PersonServiceException e) {

			System.out.println("getPerson(): " + e.getMessage());
		}

		for (PersonStock stock : listOfStock) {

			listOfStockCompany.add(stock.getStock());
		}

		System.out.println("A list of persons from the person table");

		for (Person person1 : listOfPerson) {

			System.out.println(person1);

		}

		System.out.println();

		System.out
				.println(person.getFirstName() + ' ' + person.getLastName() + " is interested in the following stocks");

		for (StockCompany company : listOfStockCompany) {

			System.out.println(company.getCompanyName() + " (" + company.getSymbol() + ')');

		}

	}

}
