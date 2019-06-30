package edu.rramirez.advancedjava.apps.stockquote;

import java.util.List;
import java.util.ArrayList;

import edu.rramirez.advancedjava.model.Person;
import edu.rramirez.advancedjava.services.PersonService;
import edu.rramirez.advancedjava.services.PersonServiceException;
import edu.rramirez.advancedjava.services.ServiceFactory;
//import java.sql.Timestamp;
//import java.util.Date;

public class PersonServiceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonService service = ServiceFactory.getPersonServiceInstance();
		List<Person> listOfPerson = null;
		
	try {
		
		listOfPerson = service.getPerson();
		
	} catch(PersonServiceException e) {
		
		System.out.println( e.getMessage());
	}
	
	System.out.println( listOfPerson);
	}

}
