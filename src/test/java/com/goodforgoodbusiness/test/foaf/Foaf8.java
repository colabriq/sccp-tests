package com.goodforgoodbusiness.test.foaf;

import static com.goodforgoodbusiness.test.foaf.Foaf.ENDPOINT_A;
import static com.goodforgoodbusiness.test.foaf.Foaf.ENGINE_A;
import static java.lang.System.out;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.engine.EngineModule;
import com.goodforgoodbusiness.test.AppTester;

public class Foaf8 {
	public static void main(String[] args) throws Exception {
		try (var engine = new AppTester(EngineModule.class, ENGINE_A)) {
			try (var rdf = new AppTester(EndpointModule.class, ENDPOINT_A)) {
				out.println(rdf.rdfClient().update(
					"PREFIX foaf: <http://xmlns.com/foaf/0.1/>                    \n" + 
					"INSERT DATA {                                                \n" + 
					"  <https://twitter.com/ijmad8x>  foaf:name 'Ian Maddison'.   \n" + 
					"  <https://twitter.com/ijmad8x>  foaf:age 35                 \n" + 
					"}                                                            \n" 
				));
				
				out.println(rdf.rdfClient().query(
					"SELECT ?name                                                           \n" + 
					"WHERE {                                                                \n" + 
					"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
					"}															            \n"
				));
				
				out.println(rdf.rdfClient().update(
					"PREFIX foaf:  <http://xmlns.com/foaf/0.1/>  \n" + 
					"DELETE {                                    \n" + 
					"  ?person foaf:name 'Ian Maddison'          \n" + 
					"}                                           \n" + 
					"INSERT {                                    \n" +  
					"  ?person foaf:name 'Hana Ijecko'           \n" + 
					"}                                           \n" + 
					"WHERE {                                     \n" +
					"  ?person foaf:name 'Ian Maddison'          \n" + 
					"}                                           \n"
				));
		
				out.println(rdf.rdfClient().query(
					"SELECT ?name                                                           \n" + 
					"WHERE {                                                                \n" + 
					"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
					"}															            \n"
				));
			}
		}
	}
}
