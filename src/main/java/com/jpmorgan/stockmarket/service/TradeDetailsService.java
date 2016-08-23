package com.jpmorgan.stockmarket.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;

/**
 * @author Vijit
 *
 * This class records data for buy/sell trades and also calculates 
 * volume weighted stock price and GBCE allshare index based on the trades recorded.
 */
public class TradeDetailsService {
	
	/** the trade list	 */
	private List<Trade> trades = new ArrayList<Trade>();

	/**
	 * Gets the list of trades
	 * @return trades
	 */
	public List<Trade> getTrades() {
		return this.trades;
	}

	/**
	 * Add trade to trade list
	 * @param trade
	 */
	public void addTrade(Trade trade) {
		this.trades.add(trade);
	}
	
	 /**
     * Calculates GBCE All Share Index using the geometric mean of the prices for all trades.
     * @return GBCE All Share Index.
     */
    public double getGBCEAllShareIndex() {
        double result = 1;
       
               
        for (Trade trade : this.trades) {
        	result *= 	trade.getPrice();
        }
        double pow = 1.0 / this.trades.size();
        result = Math.pow(result, pow);
        return result;
    }
    
    /**
     * Calculates Volume Weighted Stock Price based on trades in the past 15 minutes.
     * @return Volume Weighted Stock Price.
     */
     public double getVolumeWeightedStockPrice(Stock stock) {
    	
    	Calendar timeRange = Calendar.getInstance();
		double priceQuantitySum = 0;
		double QuantitySum = 0;

		// remove 15 minutes from the current time
		timeRange.add(Calendar.MINUTE, -15);

		for (Trade trade : this.trades) {
			if (trade.getTradeTime().after(timeRange.getTime()) && trade.getStock().equals(stock)) {
				priceQuantitySum += trade.getPrice() * trade.getQuantityShares();
				QuantitySum += trade.getQuantityShares();
			}
		}
		return priceQuantitySum / QuantitySum;
    }
    
}
