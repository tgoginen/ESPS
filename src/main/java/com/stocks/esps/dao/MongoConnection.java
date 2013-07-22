package com.stocks.esps.dao;

import java.util.List;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


public class MongoConnection {
	
	private DB db = null;
	
	public MongoConnection(ServerAddress host,String database){
		Mongo mongo = new MongoClient(host);
		db = mongo.getDB(database);
	}
	
	public MongoConnection(List<String> hostStrings, String database) {

		List<ServerAddress> hosts = new ArrayList<ServerAddress>();
		for (String host : hostStrings) {
			try {
				hosts.add(new ServerAddress(host));
			} catch (UnknownHostException e) {
			}
		}

		Mongo mongo = new MongoClient(hosts);
		db = mongo.getDB(database);
	}
	
	public DB getDB(){
		return db;
	}
	
}
