package com.jpmorgan.stockmarket.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.jpmorgan.stockmarket.domain.Stock;
import static com.jpmorgan.stockmarket.domain.StockType.COMMON;
import static com.jpmorgan.stockmarket.domain.StockType.PREFERRED;

public class StocksRepository {
	
	
	private Stock[] stocks = {
	        new Stock("TEA", COMMON,bigDecimal("0"), bigDecimal("0"),bigDecimal("100")),
            new Stock("POP", COMMON,bigDecimal("8"), bigDecimal("0"),bigDecimal("100")),
            new Stock("ALE", COMMON,bigDecimal("23"),bigDecimal("0"),bigDecimal("60")),
            new Stock("GIN", PREFERRED,bigDecimal("8"), bigDecimal("0.02"),bigDecimal("100")),
            new Stock("JOE", COMMON,bigDecimal("13"), bigDecimal("0"),bigDecimal("250"))
	};
	
	public List<Stock> getStocks(){
		return Arrays.asList(stocks);
	}
	
	private BigDecimal bigDecimal(String value){
		return new BigDecimal("value");
	}

}
