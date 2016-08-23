package com.jpmorgan.stockmarket.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import static com.jpmorgan.stockmarket.domain.StockType.PREFERRED;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;
import com.jpmorgan.stockmarket.domain.TradeType;

public class TestTradeDetailsService {
	
	TradeDetailsService tradeDetails=new TradeDetailsService();
	StockMarketService service;
	List<Stock> stockList;
	Random random = new Random();
	
	@Before
	public void setUp(){
		service= new StockMarketService();
		stockList = service.getStocks();
    	
	}
    
   
		 
    @Test
    public void testVolumeWeightedStockPrice(){
    	Stock stock = new Stock("GIN", PREFERRED,new BigDecimal("8"), new BigDecimal("0.02"),new BigDecimal("100"));
    	tradeDetails.addTrade(new Trade(stock, 10, TradeType.BUY,10d));
    	tradeDetails.addTrade(new Trade(stock, 15, TradeType.BUY,12d));
    	double expectedResult = (10d*10 + 12d*15) / (10+15);
    	assertNotNull(tradeDetails.getVolumeWeightedStockPrice(stock));
    	assertEquals(expectedResult, tradeDetails.getVolumeWeightedStockPrice(stock),0);
    }
    
    @Test
    public void testGBCEAllShareIndex(){
    	
    	tradeDetails.addTrade(new Trade(stockList.get(1), 10, TradeType.BUY,100d));
    	tradeDetails.addTrade(new Trade(stockList.get(2), 15, TradeType.BUY,120d));
    	tradeDetails.addTrade(new Trade(stockList.get(3), 12, TradeType.SELL,110d));
    	tradeDetails.addTrade(new Trade(stockList.get(2), 15, TradeType.BUY,250d));
    	tradeDetails.addTrade(new Trade(stockList.get(3), 20, TradeType.SELL,300d));
    	assertEquals(Math.pow(100d*120d*110d*250d*300d, 1.0/5.0), tradeDetails.getGBCEAllShareIndex().doubleValue(), 0);
    }

}
