package com.goodforgoodbusiness.test.beef;

import com.goodforgoodbusiness.utils.RDFClient;
 
public class ContainerIntrospectQuery {
	private static final String SAMPLE_QUERY = 
		"SELECT ?subject ?predicate ?object		" + 
		"WHERE {								" + 
		"    GRAPH <container:3853ed29802a46d6f3107d6850ba67103efd7d84e42c85615f119df58ff8109b04a6e39048f68ee523e79f28a090644e52b25bd0939bb7aa9ca90893a27c2459> {				" + 
		"        ?subject ?predicate ?object	" + 
		"    }									" + 
		"} 										"
	;
	
	public static void main(String[] args) throws Exception {
		var result = new RDFClient(8081).query(SAMPLE_QUERY);
		System.out.println(result);
	}
}
