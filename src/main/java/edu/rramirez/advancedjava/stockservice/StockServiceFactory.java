package edu.rramirez.advancedjava.stockservice;

/**
 * StockServiceFactory class - it creates a BasicStockFactory instance. This
 * class enforces the singleton pattern
 *
 * @author Ramon Ramirez
 */
public class StockServiceFactory {

	private static StockService service;

	private StockServiceFactory() {
	}

	/**
	 * It creates a BasicStockService instance.
	 * 
	 * @return a BasicStockServie instance
	 */
	public static StockService getInstance() {

		synchronized (StockServiceFactory.class) {

			if (service == null) {
				service = new BasicStockService();
			}

			return service;
		}
	}

}