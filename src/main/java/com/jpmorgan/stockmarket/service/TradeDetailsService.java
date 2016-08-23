package com.jpmorgan.stockmarket.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;

public class TradeDetailsService {
	
	private List<Trade> trades = new ArrayList<Trade>();

	public List<Trade> getTrades() {
		return trades;
	}

	public void addTrade(Trade trade) {
		trades.add(trade);
	}
	
	 /**
     * Calculates GBCE All Share Index using the geometric mean of the prices for all stocks.
     * @return GBCE All Share Index.
     */
    
    public BigDecimal getGBCEAllShareIndex() {
        BigDecimal res = new BigDecimal(1);
       
               
        for (Trade trade : trades) {
            res = res.multiply(new BigDecimal(trade.getPrice()));
        }
        double pow = 1.0 / trades.size();
        res = new BigDecimal(Math.pow(res.doubleValue(), pow));
        return res;
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

		for (Trade trade : trades) {
			if (trade.getTradeTime().after(timeRange.getTime()) && trade.getStock().equals(stock)) {
				priceQuantitySum += trade.getPrice() * trade.getQuantityShares();
				QuantitySum += trade.getQuantityShares();
			}
		}
		return priceQuantitySum / QuantitySum;
    }
    
	
	
}
