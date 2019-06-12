package com.goodforgoodbusiness.test.beef;

import com.goodforgoodbusiness.utils.RDFClient;
 
public class SelectAllQuery {
	private static final String SAMPLE_QUERY = 
		"SELECT ?s ?p ?o WHERE { ?s ?p ?o }"
	;
	
	public static void main(String[] args) throws Exception {
		var result = new RDFClient(8081).query(SAMPLE_QUERY);
		System.out.println(result);
	}
}
