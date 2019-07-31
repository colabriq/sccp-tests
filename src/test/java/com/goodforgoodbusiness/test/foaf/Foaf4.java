//package com.goodforgoodbusiness.test.foaf;
//
//import static com.goodforgoodbusiness.test.foaf.Foaf.ENDPOINT_1;
//import static com.goodforgoodbusiness.test.foaf.Foaf.ENDPOINT_2;
//import static com.goodforgoodbusiness.test.foaf.Foaf.newRunner;
//import static com.goodforgoodbusiness.test.foaf.Foaf.shareKeys;
//
//public class Foaf4 {
//	public static void main(String[] args) throws Exception {
//		newRunner(ENDPOINT_1).update(
//			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>                    \n" + 
//			"INSERT DATA {                                                \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:name 'Ian Maddison'.   \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:age 35                 \n" + 
//			"}                                                            \n" 
//		);
//		
//		shareKeys(ENDPOINT_1, ENDPOINT_2, "https://twitter.com/ijmad8x", "http://xmlns.com/foaf/0.1/name", null);
//		
//		newRunner(ENDPOINT_2).query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n",
//			"application/xml",
//			System.out
//		);
//		
//		// update from the B side
//		
//		newRunner(ENDPOINT_2).update(
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
//		newRunner(ENDPOINT_2).query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n",
//			"application/xml",
//			System.out
//		);
//		
//		// the A side should not see this update
//		
//		newRunner(ENDPOINT_1).query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n",
//			"application/xml",
//			System.out
//		);
//		
//		// share the updates from B back to A
//		
//		shareKeys(ENDPOINT_2, ENDPOINT_1, "https://twitter.com/ijmad8x", "http://xmlns.com/foaf/0.1/name", null);
//		
//		// the A side should now see Hannah Ijecko
//		
//		newRunner(ENDPOINT_1).query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n",
//			"application/xml",
//			System.out
//		);
//	}
//}
