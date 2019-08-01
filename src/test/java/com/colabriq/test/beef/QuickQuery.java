package com.goodforgoodbusiness.test.beef;

import com.goodforgoodbusiness.utils.RDFClient;

public class QuickQuery {
	public static void main(String[] args) throws Exception {
		var result = new RDFClient(8081).query("SELECT ?p ?o WHERE { ?s ?p ?o }");
		
//		var result = new RDFClient(8081).query("SELECT ?p ?o WHERE { <container:0a13e6e4762d26d2509b5b1d9b1d7bb4b72be974baae32f4ca71d79e737c4f7ade46377fd59a671e8939c682e4afe0e68143294b72e5b3f84183e4028719d750> ?p ?o }");
		System.out.println(result);
	}
}
