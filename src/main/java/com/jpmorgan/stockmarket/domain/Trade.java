package com.jpmorgan.stockmarket.domain;

import java.util.Date;

/**
 * @author Vijit
 * 
 * Model class for keeping trade information
 */
public class Trade {

	/** the stock */
	private Stock stock;
	/** the trade time */
	private Date tradeTime;
	/** the buy/sell quantity */
	private int quantityShares;
	/** the trade type */
	private TradeType tradeType;
	/** the price */
	private double price;
	
	
	
	/**
	 * Constructs trade
	 * @param stock the stock
	 * @param quantityShares the quantity of shares
	 * @param tradeType the type of trade buy/sell
	 * @param price the price
	 */
	public Trade(Stock stock, int quantityShares, TradeType tradeType, double price) {
		super();
		this.stock = stock;
		this.quantityShares = quantityShares;
		this.tradeType = tradeType;
		this.price = price;
		this.setTradeTime(new Date());
	}
	/**
	 * Gets stock
	 * @return stock
	 */
	public Stock getStock() {
		return stock;
	}
	/**
	 * Sets stock
	 * @param stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	/**
	 * Gets trade time
	 * @return tradeTime
	 */
	public Date getTradeTime() {
		return tradeTime;
	}
	/**
	 * Sets trade time
	 * @param tradeTime
	 */
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	/**
	 * Gets quantity of shares
	 * @return quantityShares
	 */
	public int getQuantityShares() {
		return quantityShares;
	}
	/**
	 * Sets quantity of shares 
	 * @param quantityShares
	 */
	public void setQuantityShares(int quantityShares) {
		this.quantityShares = quantityShares;
	}
	/**
	 * Gets type of trade
	 * @return tradeType
	 */
	public TradeType getTradeType() {
		return tradeType;
	}
	/**
	 * Sets trade type
	 * @param tradeType
	 */
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	/**
	 * Gets price
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
		
}
