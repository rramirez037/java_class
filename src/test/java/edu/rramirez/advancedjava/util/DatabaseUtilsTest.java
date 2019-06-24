package edu.rramirez.advancedjava.util;

import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {

    @Test
    public void testGetConnection() throws DatabaseConnectionException{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection ok",connection);
    }

    @Test
    public void testGetConnectionWorks() throws DatabaseConnectionException, SQLException, IOException{
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from quotes");
        assertTrue("verify that we can execute a statement",execute);
    }
    
    /**
     * I wasn't able to implement a test for this methods. The error says that it couldn't commit
     * because the autocommit=true. I was not able to set it to false
     * 
     * @Test
    public void testInitializeDatabase() throws DatabaseInitializationException {
    
    	try {
    		
    		Connection connection = DatabaseUtils.getConnection();
			Statement statement = connection.createStatement();

			statement.executeQuery("set autocommit = 0");
    	
    	DatabaseUtils.initializeDatabase("C:\\Users\\Ramon\\GitHub\\java_class\\src\\main\\sql\\stocks_db_initialization.sql");
    	
    	statement.execute("set autocommit = 1");
    	
    	} catch (DatabaseConnectionException | SQLException e) {
        	
            throw new DatabaseInitializationException("Could not initialize db because of:"
                    + e.getMessage(),e);
         }
    }*/
}
