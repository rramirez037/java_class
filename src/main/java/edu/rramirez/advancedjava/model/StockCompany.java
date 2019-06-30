package edu.rramirez.advancedjava.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Models the company table
 * 
 * @author Ramon Ramirez
 *
 */
@Entity
@Table ( name = "company" )
public class StockCompany {
	
	private String symbol;
	private String name;
	
	/**
	 * Constructor to initialize the instances
	 * 
	 * @param symbol the company symbol
	 * @param name the company name
	 */
	public StockCompany(String symbol, String name) {
		setSymbol(symbol);
		setName(name);
	}
	
	/**
	 * It set the company symbol
	 * 
	 * @param symbol a unique value
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	/**
	 * It set the company name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Primary Key - each company should has an unique symbol
	 * 
	 * @return an string value
	 */
	@Id
	@Basic
	@Column ( name = "symbol", nullable = false, insertable = true, updatable = true)
	public String getSymbol() {
		return symbol;
	}
	
	/**
	 * The company name associated with the symbol
	 * 
	 * @return an string value
	 */
	@Basic
	@Column ( name = "company_name", nullable = false, insertable = true, updatable = true)
	public String getName() {
		return name;
	}

}
