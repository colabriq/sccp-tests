package com.goodforgoodbusiness.test.foaf;

import com.goodforgoodbusiness.utils.RDFClient;

public class Foaf1A {
	public static void main(String[] args) throws Exception {		
		var client = new RDFClient(8081);
		
//		var result1 = client.update(
//			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>                    \n" + 
//			"INSERT DATA {                                                \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:name 'Ian Maddison'.   \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:age 35                 \n" + 
//			"}                                                            \n" 
//		);
//		
//		System.out.println(result1);
		
		var result2 = client.query(
			"SELECT ?name                                                           \n" + 
			"WHERE {                                                                \n" + 
			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
			"}															            \n"
		);
		
		System.out.println(result2);
//		
//		var result3 = client.update(
//			"PREFIX foaf:  <http://xmlns.com/foaf/0.1/>  \n" + 
//			"DELETE {                                    \n" + 
//			"  ?person foaf:name 'Ian Maddison'          \n" + 
//			"}                                           \n" + 
//			"INSERT {                                    \n" +  
//			"  ?person foaf:name 'Hana Ijecko'           \n" + 
//			"}                                           \n" + 
//			"WHERE {                                     \n" +
//			"  ?person foaf:name 'Ian Maddison'          \n" + 
//			"}                                           \n"
//		);
//
//		System.out.println(result3);
//		
//		var result4 = client.query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n"
//		);
//		
//		System.out.println(result4);
	}
}
