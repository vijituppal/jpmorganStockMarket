package com.jpmorgan.stockmarket.domain;

import java.math.BigDecimal;

/**
 * @author Vijit
 * The Stock model class to hold information about stock
 *
 */
public class Stock {
	
	/** the stock symbol */
	private String symbol;
	/** the stock type */
	private StockType type;
	/** the stock last dividend */
	private BigDecimal lastDividend;
	/** the stock fixed dividend */
	private BigDecimal fixedDividend;
	/** the stock par value */
	private BigDecimal parValue;
	
	/**
	 * Construct the stock
	 * @param symbol the symbol
	 * @param type the type
	 * @param lastDividend the last dividend
	 * @param fixedDividend the fixed dividend
	 * @param parValue the par value
	 */
	public Stock(String symbol, StockType type, BigDecimal lastDividend, BigDecimal fixedDividend, BigDecimal parValue
			) {
		super();
		this.symbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}
	
	/**
	 * Gets symbol
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * Sets symbol
	 * @param symbol
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	/**
	 * Gets the type
	 * @return type
	 */
	public StockType getType() {
		return type;
	}
	/** 
	 * Sets the type
	 * @param type
	 */
	public void setType(StockType type) {
		this.type = type;
	}
	/**
	 * Gets the last dividend
	 * @return last dividend
	 */
	public BigDecimal getLastDividend() {
		return lastDividend;
	}
	/**
	 * Sets the last dividend
	 * @param lastDividend
	 */
	public void setLastDividend(BigDecimal lastDividend) {
		this.lastDividend = lastDividend;
	}
	/**
	 * Gets fixed dividend
	 * @return fixed dividend
	 */
	public BigDecimal getFixedDividend() {
		return fixedDividend;
	}
	/**
	 * Sets fixed dividend
	 * @param fixedDividend
	 */
	public void setFixedDividend(BigDecimal fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	/**
	 * Gets par value
	 * @return par value
	 */
	public BigDecimal getParValue() {
		return parValue;
	}
	/**
	 * Sets par value
	 * @param parValue
	 */
	public void setParValue(BigDecimal parValue) {
		this.parValue = parValue;
	}

}
