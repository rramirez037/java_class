package edu.rramirez.advancedjava.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Stocks implements XMLDomainObject {
	
	@XmlElement(name ="stock")
    protected List<Stock> stocks;

	/**
     * Gets the value of the stock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stock }
     * 
     * 
     */
    public List<Stock> getStock() {
    	
    	if( stocks == null)
    		stocks = new ArrayList<>();
    	
        return stocks;
    }

    @Override
    public String toString() {
        return "Stocks{" +
                "stock=" + stocks +
                '}';
    }
}
