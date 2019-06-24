package com.goodforgoodbusiness.test.beef;

import com.goodforgoodbusiness.utils.RDFClient;
 
public class SelectAllQuery {
	public static void main(String[] args) throws Exception {
		var result = new RDFClient(8081).query("SELECT ?s ?p ?o WHERE { ?s ?p ?o }");
		System.out.println(result);
	}
}
