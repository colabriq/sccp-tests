//package com.goodforgoodbusiness.test.foaf;
//
//import static com.goodforgoodbusiness.test.foaf.Foaf.ENDPOINT_1;
//import static com.goodforgoodbusiness.test.foaf.Foaf.ENDPOINT_2;
//import static com.goodforgoodbusiness.test.foaf.Foaf.shareKeys;
//
//import com.goodforgoodbusiness.utils.RDFClient;
//
//public class Foaf3 {
//	public static void main(String[] args) throws Exception {
//		RDFClient.fromConfig(Foaf.class, ENDPOINT_1).update(
//			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>                    \n" + 
//			"INSERT DATA {                                                \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:name 'Ian Maddison'.   \n" + 
//			"  <https://twitter.com/ijmad8x>  foaf:age 35                 \n" + 
//			"}                                                            \n" 
//		);
//		
//		shareKeys(ENDPOINT_1, ENDPOINT_2, "https://twitter.com/ijmad8x", "http://xmlns.com/foaf/0.1/name", null);
//		
//		Thread.sleep(5000);
//		
//		var result =
//		RDFClient.fromConfig(Foaf.class, ENDPOINT_2).query(
//			"SELECT ?name                                                           \n" + 
//			"WHERE {                                                                \n" + 
//			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
//			"}															            \n"
//		);
//		
//		System.out.println(result);
//	}
//}
