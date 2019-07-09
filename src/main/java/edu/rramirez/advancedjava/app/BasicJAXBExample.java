package edu.rramirez.advancedjava.app;

import edu.rramirez.advancedjava.services.ServiceFactory;
import edu.rramirez.advancedjava.services.StockServiceException;
import edu.rramirez.advancedjava.services.XMLService;
import edu.rramirez.advancedjava.util.InvalidXMLException;
import edu.rramirez.advancedjava.util.XMLUtils;
import edu.rramirez.advancedjava.xml.Stock;
import edu.rramirez.advancedjava.xml.Stocks;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * A basic app convert a XML file content into objects, then storage in a database
 * using hibernate.
 */
public class BasicJAXBExample {

	public static void main(String[] args) throws IOException {

		String xmlInstance = null;
		
		
		try {
			// Reading the content of the stock_info.xml into a StringBuilder
			InputStream inputStream = new FileInputStream("./src/main/resources/xml/stock_info.xml");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
			String line = buffer.readLine();
			StringBuilder stringBuilder = new StringBuilder();

			while (line != null) {
				stringBuilder.append(line).append("\n");
				line = buffer.readLine();
			}
			
			xmlInstance = stringBuilder.toString();
			
		} catch (IOException e) {
			
			System.out.println("Error opening or processing the file " + e.getMessage());
		}
		
		
		Stocks stocks = null;
		
		try {
			//Converting java objects from the XML file
			stocks = (Stocks) XMLUtils.unmarshall(xmlInstance, Stocks.class);
			
		} catch (InvalidXMLException e) {
			
			System.out.println("Error parsing the XML file " + e.getMessage());
		}
		
		List<Stock> stockData = stocks.getStock();
		
		XMLService service = ServiceFactory.getXMLServiceInstance();
		
		try {
			//Saving the data
			service.saveStock(stockData);
			
		} catch (StockServiceException e) {
			
			System.out.println( e.getMessage() );
		}
		

		System.out.println("---Progran Ended---");
	}
}
