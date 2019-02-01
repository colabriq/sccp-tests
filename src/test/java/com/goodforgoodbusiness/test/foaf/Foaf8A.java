package com.goodforgoodbusiness.test.foaf;

import static java.lang.System.out;

import com.goodforgoodbusiness.utils.RDFClient;

public class Foaf8A {
	public static void main(String[] args) throws Exception {
		out.println(new RDFClient(8080).update(
			"PREFIX foaf: <http://xmlns.com/foaf/0.1/>                    \n" + 
			"INSERT DATA {                                                \n" + 
			"  <https://twitter.com/ijmad8x>  foaf:name 'Ian Maddison'.   \n" + 
			"  <https://twitter.com/ijmad8x>  foaf:age 35                 \n" + 
			"}                                                            \n" 
		));
		
		out.println(new RDFClient(8080).query(
			"SELECT ?name                                                           \n" + 
			"WHERE {                                                                \n" + 
			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
			"}															            \n"
		));
		
		out.println(new RDFClient(8080).update(
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

		out.println(new RDFClient(8080).query(
			"SELECT ?name                                                           \n" + 
			"WHERE {                                                                \n" + 
			"  <https://twitter.com/ijmad8x> <http://xmlns.com/foaf/0.1/name> ?name \n" + 
			"}															            \n"
		));
	}
}
