package com.stocks.esps.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.stocks.esps.models.CompanyStockPrice;

public class CompanyHistoricalStockPriceDAO {

	
	private MongoConnection mongoConnection;
	private String mongoServerAddress = "127.0.0.1:27017";
	private String databaseName = "ESPS";
	private DBCollection dbCollection;
	
	private String datekeyField = "date";
	private String priceKeyField = "closingPrice";
	public CompanyHistoricalStockPriceDAO(String companySymbol){
		
		List<String> serverAddresses = new ArrayList<String>();
		serverAddresses.add(mongoServerAddress);
		mongoConnection = new MongoConnection(serverAddresses, databaseName);
		dbCollection = mongoConnection.getDB().getCollection(companySymbol);
	}
	
	public List<CompanyStockPrice> getHistoricalQutoes(Date fromDate,Date toDate){
		
		List<CompanyStockPrice> stockPriceHistory = new ArrayList<CompanyStockPrice>();
		
		BasicDBObject queryObject = new BasicDBObject().append(datekeyField, new BasicDBObject("$gte", fromDate)).append(datekeyField, new BasicDBObject("$lte",toDate));
		
		DBCursor stockPriceCursor = dbCollection.find(queryObject);
		
		while( stockPriceCursor.hasNext()){
			DBObject stockEntry = stockPriceCursor.next();
			CompanyStockPrice stockPrice = new CompanyStockPrice();
			stockPrice.setDate((Date)stockEntry.get(datekeyField));
			stockPrice.setPrice((Double)stockEntry.get(priceKeyField));
			stockPriceHistory.add(stockPrice);
		}
		
		return stockPriceHistory;
		
	}
	
	public List<CompanyStockPrice> getAllHistoricalQuotes(){
		List<CompanyStockPrice> stockPriceHistory = new ArrayList<CompanyStockPrice>();
		
		
		DBCursor stockPriceCursor = dbCollection.find();
		
		while( stockPriceCursor.hasNext()){
			DBObject stockEntry = stockPriceCursor.next();
			CompanyStockPrice stockPrice = new CompanyStockPrice();
			stockPrice.setDate((Date)stockEntry.get(datekeyField));
			stockPrice.setPrice((Double)stockEntry.get(priceKeyField));
			stockPriceHistory.add(stockPrice);
		}
		
		return stockPriceHistory;
	}
}
