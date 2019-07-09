package edu.rramirez.advancedjava.xml;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class StocksTest {

	private static String xmlInstance ="<stocks>\n" +
            "    <stock symbol=\"VNET\" price=\"110.10\" time=\"2015-02-10 00:00:01\"/>\n" + 
            "    <stock symbol=\"AGTK\" price=\"120.10\" time=\"2015-02-10 00:00:01\"/>\n" + 
            "    <stock symbol=\"AKAM\" price=\"3.10\" time=\"2015-02-10 00:00:01\"/>\n" + 
            "    <stock symbol=\"AOL\"  price=\"30.10\" time=\"2015-02-10 00:00:01\"/>\n" +
            "</stocks>";
	
	@Test
	public void test() throws JAXBException {
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        
        assertEquals("Id is correct", 4, stocks.getStock().size());
	}
	


}
