package edu.rramirez.advancedjava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Models a table that combines person with their stocks interest.
 * 
 * @author Ramon Ramirez
 *
 */
@Entity
@Table (name = "person_stock", catalog = "stocks")
public class PersonStock {
	
	private int id;
	private Person person;
	private StockCompany stock;
	
	/**
	 * This empty constructor is required by the hibernate framework
	 */
	public PersonStock() { }
	
	/**
	 * Create a person stock interest
	 * 
	 * @param person the person with the interest on the stock
	 * @param stock the stock of interest
	 */
	public PersonStock( Person person, StockCompany stock ) {
		
		setPerson(person);
		setStock(stock);
	}
	
	/**
	 * Primary Key - unique id that identify each row in the person_interest table
	 * 
	 * @return an integer value
	 */
	@Id
	@Column ( name = "ID", nullable = false, insertable = true, updatable = true )
	public int getId() {
		return id;
	}
	
	/**
	 * Set the unique ID for a particular row in the person_interest table.
	 * This method should not be called by client code. The value is managed internally.
	 * 
	 * @param id an integer representing a unique value
	 */
	public void setId( int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return the person associated with the stock
	 */
	@ManyToOne
	@JoinColumn ( name = "person_id", referencedColumnName = "ID", nullable = false )
	public Person getPerson() {
		return person;
	}
	
	/**
	 * It associates a person to a stock
	 * 
	 * @param person the person interested in the stock
	 */
	public void setPerson( Person person) {
		this.person = person;
	}
	
	/**
	 * 
	 * @return the stock associated with this person
	 */
	@ManyToOne
	@JoinColumn ( name = "company_id", referencedColumnName = "symbol", nullable = false )
	public StockCompany getStock() {
		return stock;
	}
	
	/**
	 * It associates a stock to a person
	 * 
	 * @param stock the stock of interest
	 */
	public void setStock( StockCompany stock ) {
		this.stock = stock;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStock that = (PersonStock) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + stock.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonStock{" +
                "id=" + id +
                ", person=" + person +
                ", stock=" + stock +
                '}';
    }
	
}
