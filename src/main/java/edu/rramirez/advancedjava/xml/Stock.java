package edu.rramirez.advancedjava.xml;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;

/**
 * This is JAXB class to hold the data from a XML file and it
 * also uses hibernate to mapped to a table in a database for storage.
 * 
 * @author Ramon Ramirez
 *
 */

@Entity
@Table(name = "quotes", catalog = "stocks")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "stock")
public class Stock implements XMLDomainObject{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

	@Column ( name = "symbol", nullable = false, insertable = true, updatable = true)
	@XmlAttribute(name = "symbol", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String symbol;
	
	@Column ( name = "price", nullable = false, insertable = true, updatable = true)
    @XmlAttribute(name = "price", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String price;
    
	@Column ( name = "time", nullable = false, insertable = true, updatable = true)
    @XmlAttribute(name = "time", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String time;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
    /**
     * Gets the value of the symbol attribute.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol attribute.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }
    
    /**
     * Gets the value of the price attribute.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price attribute.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrice(String value) {
        this.price = value;
    }
    
    /**
     * Gets the value of the time attribute.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time attribute.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }
    
    @Override
    public String toString() {
        return "Stock{" +
                "Symbol='" + symbol + '\'' +
                ", price='" + price + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
