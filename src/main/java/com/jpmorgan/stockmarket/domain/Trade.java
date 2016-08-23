package com.jpmorgan.stockmarket.domain;

import java.util.Date;

public class Trade {

	private Stock stock;
	private Date tradeTime;
	private int quantityShares;
	private TradeType tradeType;
	private double price;
	
	
	
	public Trade(Stock stock, int quantityShares, TradeType tradeType, double price) {
		super();
		this.stock = stock;
		this.quantityShares = quantityShares;
		this.tradeType = tradeType;
		this.price = price;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}
	public int getQuantityShares() {
		return quantityShares;
	}
	public void setQuantityShares(int quantityShares) {
		this.quantityShares = quantityShares;
	}
	public TradeType getTradeType() {
		return tradeType;
	}
	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
		
}
