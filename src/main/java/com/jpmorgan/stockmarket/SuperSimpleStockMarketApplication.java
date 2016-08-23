package com.jpmorgan.stockmarket;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;
import com.jpmorgan.stockmarket.domain.TradeType;
import com.jpmorgan.stockmarket.service.StockMarketService;
import com.jpmorgan.stockmarket.service.TradeDetailsService;

public class SuperSimpleStockMarketApplication {
	
	public static void main (String[] args){
		
		StockMarketService service = new StockMarketService();
		Random random = new Random();
		List<Stock> stocks = service.getStocks();
		Stock stock = stocks.iterator().next();
		System.out.println("The Dividend Yield of stock "+stock.getSymbol()+" :"+service.getDividendYield(stock, new BigDecimal(500)));
		System.out.println();
		System.out.println("The P/E ratio of stock "+stock.getSymbol()+" :"+service.getPERatio(stock, new BigDecimal(500)));
		System.out.println();
		
		 //Trade
    	TradeDetailsService tradeDetails = new TradeDetailsService();
    	
    	for(int i = 1; i <= 100; i++){ 
    		tradeDetails.addTrade(new Trade(stocks.get(random.nextInt(5)), random.nextInt(500), random.nextBoolean()?TradeType.BUY:TradeType.SELL, random.nextInt(500)));
    	}
    	
    	System.out.println("The volume weighted stock price of stock "+stock.getSymbol()+":"+service.getVolumeWeightedStockPrice(stock));
    	System.out.println();
    	System.out.println("Calculated GBCE All share index is "+service.getGBCEAllShareIndex());
    	
	}

}
