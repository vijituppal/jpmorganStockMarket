package com.jpmorgan.stockmarket.service;

import java.math.BigDecimal;
import java.util.List;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.StockType;
import com.jpmorgan.stockmarket.repository.StocksRepository;

public class StockMarketService {
	
	
	TradeDetailsService details = new TradeDetailsService();
    /**
     *
     * @param stock A stock to be used during the calculation of the dividend yield.
     * @param price Price to be used during the calculation of the dividend yield.
     * @return
     * @throws IllegalArgumentException if price is zero
     */
    public BigDecimal getDividendYield(Stock stock, BigDecimal price) {
    	BigDecimal dividendYield;
    	if(stock.getType().equals(StockType.COMMON)){
         dividendYield = stock.getLastDividend().divide(price);
    	}else{
    	 dividendYield = (stock.getFixedDividend().multiply(stock.getParValue())).divide(price);
    	}
        return dividendYield;
    }

    /**
     *
     * @param stock A stock to be used during the calculation of the PE ratio.
     * @param price Price to be used during the calculation of the PE ratio.
     * @return PE ratio
     */
    public BigDecimal getPERatio(Stock stock, BigDecimal price) {
        BigDecimal dividend = stock.getLastDividend();
        BigDecimal peRatio = new BigDecimal(0);
        if( stock.getLastDividend().intValue() == 0){
            return peRatio;
        }
        peRatio = price.divide(dividend);
        return peRatio;
    }
    
 

    /**
     * Calculates Volume Weighted Stock Price based on trades in the past 15 minutes.
     * @return Volume Weighted Stock Price.
     */
    
    public double getVolumeWeightedStockPrice(Stock stock) {
    	
		return details.getVolumeWeightedStockPrice(stock);
    }

    /**
     * Calculates GBCE All Share Index using the geometric mean of the prices for all stocks.
     * @return GBCE All Share Index.
     */
    
    public BigDecimal getGBCEAllShareIndex() {
       
        return details.getGBCEAllShareIndex();
    }
    
    public List<Stock> getStocks(){
    	StocksRepository repository = new StocksRepository();
    	return repository.getStocks();
    }

}
