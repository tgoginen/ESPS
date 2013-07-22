package com.stocks.esps.dao;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.stocks.esps.models.CompanyInfo;

public class CompanyInfoDAO {

	private MongoConnection mongoConnection;
	private String mongoServerAddress = "127.0.0.1:27017";
	private String databaseName = "ESPS";
	private String companyListCollection = "CompanyList";
	private DBCollection dbCollection;
	
	public CompanyInfoDAO(){
		List<String> serverAddresses = new ArrayList<String>();
		serverAddresses.add(mongoServerAddress);
		mongoConnection = new MongoConnection(serverAddresses, databaseName);
		dbCollection = mongoConnection.getDB().getCollection(companyListCollection);
	}
	
	public List<CompanyInfo> getAllCompaniesInfo(){
		List<CompanyInfo> companyInfoList = new ArrayList<CompanyInfo>();
		
		DBCursor dbCursor = dbCollection.find();
		while(dbCursor.hasNext()){
			DBObject dbo = dbCursor.next();
			CompanyInfo companyEntry = getCompanyInfo(dbo);
			if(companyEntry != null){
				companyInfoList.add(companyEntry);
			}
		}
		
		return companyInfoList;
	}
	
	public CompanyInfo getCompanyInfo(DBObject dbObject){
		if(dbObject == null ) return null;
		String companySymbol = dbObject.get("Symbol").toString();
		String companyName = dbObject.get("Name").toString();
		CompanyInfo companyInfo = new CompanyInfo(companySymbol);
		companyInfo.setCompanyName(companyName);
	//	System.out.println(companySymbol);
		return companyInfo;
	}
}
