package edu.rramirez.advancedjava.services;

/**
 * A factory that returns a <CODE>StockService || PersonService || XMLService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
	public static StockService getStockServiceInstance() {
		return new DatabaseService();
	}
	
	/**
    *
    * @return get a <CODE>PersonService</CODE> instance
    */
	public static PersonService getPersonServiceInstance() {
		return new DatabaseService();
	}
	
	/**
    *
    * @return get a <CODE>XMLService</CODE> instance
    */
	public static XMLService getXMLServiceInstance() {
		return new DatabaseService();
	}
}
