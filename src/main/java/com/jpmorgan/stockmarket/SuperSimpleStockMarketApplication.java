package com.jpmorgan.stockmarket;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import com.jpmorgan.stockmarket.domain.Stock;
import com.jpmorgan.stockmarket.domain.Trade;
import com.jpmorgan.stockmarket.domain.TradeType;
import com.jpmorgan.stockmarket.service.StockMarketService;
import com.jpmorgan.stockmarket.service.TradeDetailsService;

/**
 * @author Vijit
 * 
 * Main application class which executes every implemented functionality 
 * of stock market application/features.
 */
public class SuperSimpleStockMarketApplication {
	
	/**
	 * Main method 
	 * @param args
	 */
	public static void main (String[] args){
		
		StockMarketService service = new StockMarketService();
		Random random = new Random();
		List<Stock> stocks = service.getStocks();
		Stock stock = stocks.get(3);
		System.out.println("The Dividend Yield of stock "+stock.getSymbol()+" :"+service.getDividendYield(stock, new BigDecimal(500)));
		System.out.println();
		System.out.println("The P/E ratio of stock "+stock.getSymbol()+" :"+service.getPERatio(stock, new BigDecimal(500)));
		System.out.println();
		
		 //Trade
    	TradeDetailsService tradeDetailService = new TradeDetailsService();
    	
    	for(int i = 1; i <= 30; i++){ 
    		tradeDetailService.addTrade(new Trade(stocks.get(random.nextInt(5)), random.nextInt(150), random.nextBoolean()?TradeType.BUY:TradeType.SELL, random.nextInt(300)));
    	}
    	
    	System.out.println("The volume weighted stock price of stock "+stock.getSymbol()+":"+tradeDetailService.getVolumeWeightedStockPrice(stock));
    	System.out.println();
    	System.out.println("Calculated GBCE All share index is "+tradeDetailService.getGBCEAllShareIndex());
    	
	}

}
