package com.goodforgoodbusiness.test;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;

public class MongoUtils {
	/**
	 * Use with caution!
	 */
	public static void clear(String connectionUrl) {
		var connectionString = new ConnectionString(connectionUrl);
		var client =  MongoClients.create(connectionString);
		var database = client.getDatabase(connectionString.getDatabase());
		
		for (var collection : database.listCollectionNames()) {
			database.getCollection(collection).deleteMany(new BasicDBObject());
		}
	}
}
