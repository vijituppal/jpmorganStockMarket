package com.jpmorgan.stockmarket.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static com.jpmorgan.stockmarket.domain.StockType.PREFERRED;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;
import com.jpmorgan.stockmarket.domain.TradeType;

/**
 * @author Vijit
 * Test class for testing TradeDetailsService methods
 */
public class TestTradeDetailsService {
	
	/** Trade detail service instance */
	private TradeDetailsService tradeDetails = new TradeDetailsService();
	/** the stock market service */
	private StockMarketService service;
	/** the stock list */
	private List<Stock> stockList;
	/** the random instance to generate random number */
	private Random random = new Random();
	
	/**
	 * Set up data for testing methods
	 */
	@Before
	public void setUp(){
		service= new StockMarketService();
		stockList = service.getStocks();
    	
	}
    
   
		 
    /**
     *  Test volume weighted stock price 
     */
    @Test
    public void testVolumeWeightedStockPrice(){
    	Stock stock = new Stock("GIN", PREFERRED,new BigDecimal("8"), new BigDecimal("0.02"),new BigDecimal("100"));
    	tradeDetails.addTrade(new Trade(stock, 10, TradeType.BUY,10d));
    	tradeDetails.addTrade(new Trade(stock, 15, TradeType.BUY,12d));
    	double expectedResult = (10d*10 + 12d*15) / (10+15);
    	assertNotNull(tradeDetails.getVolumeWeightedStockPrice(stock));
    	assertEquals(expectedResult, tradeDetails.getVolumeWeightedStockPrice(stock),0);
    }
    
    /**
     * Test GBCE All share index for trades
     */
    @Test
    public void testGBCEAllShareIndex(){
    	
    	tradeDetails.addTrade(new Trade(stockList.get(1), 10, TradeType.BUY,100d));
    	tradeDetails.addTrade(new Trade(stockList.get(2), 15, TradeType.BUY,120d));
    	tradeDetails.addTrade(new Trade(stockList.get(3), 12, TradeType.SELL,110d));
    	tradeDetails.addTrade(new Trade(stockList.get(2), 15, TradeType.BUY,250d));
    	tradeDetails.addTrade(new Trade(stockList.get(3), 20, TradeType.SELL,300d));
    	assertEquals(Math.pow(100d*120d*110d*250d*300d, 1.0/5.0), tradeDetails.getGBCEAllShareIndex(), 0);
    }
    
    /**
     * Clean up resources created for tests
     */
    @After
	public void cleanUp(){
		 service= null;
		 stockList = null;
		 tradeDetails = null;
		 
	}

}
