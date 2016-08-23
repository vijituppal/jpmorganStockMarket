package com.jpmorgan.stockmarket.service;

import java.math.BigDecimal;
import java.util.List;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.StockType;
import com.jpmorgan.stockmarket.repository.StocksRepository;

/**
 * @author Vijit
 * This class populates stocks from repository and responsible for calculating
 * dividend yield and P/E ratio for stocks using price.
 */
public class StockMarketService {
	
	
    /**
     * @param stock the stock for which dividend yield is to be calculated.
     * @param price the price used for calculating dividend yield.
     * @return dividend yield
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
     * @param stock the stock for which dividend yield is to be calculated.
     * @param price the price used for calculating dividend yield.
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
     * Populates stock list from repository
     * @return list of stocks
     */
    public List<Stock> getStocks(){
    	StocksRepository repository = new StocksRepository();
    	return repository.getStocks();
    }

}
