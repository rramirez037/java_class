package edu.rramirez.advancedjava.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

/**
 * A container class that contains stock data.
 */
@Entity
@Table (name="quotes")
public class StockQuote extends StockData {

    private BigDecimal price;
    private Date date;
    private String symbol;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */
    public StockQuote(BigDecimal price, Date date, String symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return the stock price
     */
    @Column (name = "price", nullable = false, insertable = true, updatable = true)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    @Column (name = "time", nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    @Column (name = "symbol", nullable = false, insertable = true, updatable = true)
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
    	
        String dateString = simpleDateFormat.format(date);
        
        return "StockQuote{price=" + price + ", date=" + dateString + ", symbol='" + symbol + '\'' + '}';
    }
}