package edu.rramirez.advancedjava.stockservice;
 
/**
 * StockServiceFactory class
 * This class return a BasicStockService instance
 * It enforces the singleton pattern
 *
 * @author Ramon Ramirez
 */
 public class StockServiceFactory{
	 
	 private static StockService service;
	 
	 private StockServiceFactory(){} //enforce the singleton pattern
	 
	 public static StockService getInstance(){
		 
		 synchronized( StockServiceFactory.class ){
			 
			 if( service == null ){
				 service = new BasicStockService();
			 }
			 
			 return service;
		 }
	 }
	 
 }