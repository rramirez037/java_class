package edu.rramirez.advancedjava.apps.stockquote;

import java.sql.Connection;
import edu.rramirez.advancedjava.util.DatabaseUtils;
import edu.rramirez.advancedjava.util.DatabaseConnectionException;

public class TestApp {

	public static void main(String[] args) {

		try {

			Connection connection = DatabaseUtils.getConnection();
			System.out.println("Connection established " + connection);

		} catch (DatabaseConnectionException e) {
			System.out.println( e.getMessage() );

		}

	}

}