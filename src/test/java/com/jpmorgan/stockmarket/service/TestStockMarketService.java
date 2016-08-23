package com.jpmorgan.stockmarket.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.stockmarket.domain.Stock;;

/**
 * @author Vijit
 * This test class is responsible for testing StockMarketService class methods
 */
public class TestStockMarketService {
	
	/** the stock market service */
	private StockMarketService service;
	/** the stock list */
	private List<Stock> stockList;
	/** the stock */
	private Stock stock;
	
	/**
	 * Set up data required for tests.
	 */
	@Before
	public void setUp(){
		 service= new StockMarketService();
		 stockList = service.getStocks();
		 stock = stockList.get(3);
		 
	}
	
	/**
	 * Test dividend yield for common stock type.
	 */
	@Test
	public void testDividendYieldCommonStock(){
		stock = stockList.get(2);
		assertNotNull(service.getDividendYield(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal("0.23"), service.getDividendYield(stock, new BigDecimal(100)));
	}
	
	/**
	 * Test dividend yield for preferred stock type.
	 */
	@Test
	public void testDividendYieldPreferredStock(){
		assertNotNull(service.getDividendYield(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal("0.02"), service.getDividendYield(stock, new BigDecimal(100)));
		
	}
	
	/**
	 * Test PE Ratio for given stock and price
	 */
	@Test
	public void testPERatio(){
		assertNotNull(service.getPERatio(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal(12.5), service.getPERatio(stock, new BigDecimal(100)));
	}
	
	/**
     * Clean up resources created for tests
     */
	@After
	public void cleanUp(){
		 service= null;
		 stockList = null;
		 stock = null;
		 
	}
}
