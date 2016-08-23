# jpmorganStockMarket
jpMorgan test

SuperSimpleStockMarket is the main class which runs through all the features of this application.

Data for stock is prepared in the StockMarketRepository class by populating stock instances.

StockMarketService calculates dividend yield and P/E ratio for particular stock and price.

TradeDetailsService records trade data and calculates Volume Weighted Stock Price based on trades in past 15 minutes 
Also calculate the GBCE All Share Index using the geometric mean of prices for all stocks 

Created 2 model classes Stock and Trade with required fields.

Created 2 Enums StockType (Common, Preferred) and TradeType (Buy,Sell).

Logging and exception handling are intentionally ignored as of now As it is less important because data is hardcoded and less in volume.
Could be added later.
