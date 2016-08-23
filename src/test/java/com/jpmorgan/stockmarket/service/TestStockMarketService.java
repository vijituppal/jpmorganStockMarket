package com.jpmorgan.stockmarket.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jpmorgan.stockmarket.domain.Stock;;

public class TestStockMarketService {
	
	StockMarketService service;
	List<Stock> stockList;
	Stock stock;
	
	@Before
	public void setUp(){
		 service= new StockMarketService();
		 stockList = service.getStocks();
		 stock = stockList.get(3);
		 
	}
	@Test
	public void testDividendYieldCommonStock(){
		stock = stockList.get(2);
		assertNotNull(service.getDividendYield(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal("0.23"), service.getDividendYield(stock, new BigDecimal(100)));
	}
	
	@Test
	public void testDividendYieldPreferredStock(){
		assertNotNull(service.getDividendYield(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal("0.02"), service.getDividendYield(stock, new BigDecimal(100)));
		
	}
	
	@Test
	public void testPERatio(){
		assertNotNull(service.getPERatio(stock, new BigDecimal(100)));
		assertEquals(new BigDecimal(12.5), service.getPERatio(stock, new BigDecimal(100)));
	}
	
	@After
	public void cleanUp(){
		 service= null;
		 stockList = null;
		 stock = null;
		 
	}
}
