package com.goodforgoodbusiness.test;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.sparql.resultset.ResultsFormat;

import com.goodforgoodbusiness.endpoint.graph.base.BaseDatasetProvider;
import com.goodforgoodbusiness.endpoint.graph.base.BaseGraph;
import com.goodforgoodbusiness.endpoint.graph.container.ContainerCollector;
import com.goodforgoodbusiness.endpoint.graph.container.ContainerStore;
import com.goodforgoodbusiness.endpoint.graph.container.ContainerizedGraph;

public class JenaTest {
	public static void main(String[] args) throws Exception {
		var containerStore = new ContainerStore();
		var containerCollector = new ContainerCollector(); 
		
		var preloadedGraph = new BaseGraph();
		var fetchedGraph = new ContainerizedGraph(containerStore, containerCollector);
		var inferredGraph = new BaseGraph();
		
		var dataset = new BaseDatasetProvider(preloadedGraph, fetchedGraph, inferredGraph).get();
		
		
		Files.walk(Paths.get("src/test/resources/beef/test/generated_claims"))
	        .filter(Files::isRegularFile)
	        .forEach(path -> {
	        	System.out.println(path);

	        	try (var is = new FileInputStream(path.toFile())) {
	        		var model = dataset.getDefaultModel();
	        		model.read(is, null, "TTL");
	        	}
	        	catch (IOException e) {
	        		throw new RuntimeException(e);
	        	}
	        })
	    ;
		
		System.out.println(preloadedGraph.size());
		System.out.println(fetchedGraph.size());
		System.out.println(inferredGraph.size());
		
		var query = QueryFactory.create(
				"PREFIX com: <https://schemas.goodforgoodbusiness.com/common-operating-model/lite/>" +
						"SELECT ?buyerRef ?quantity ?unitPrice ?shipmentRef ?ain ?vaccine WHERE {" + 
						"    ?order com:buyer <urn:uuid:448c5299-b858-4eb1-bc55-0a7a6c04efee>;" + 
						"        com:buyerRef ?buyerRef;" + 
						"        com:quantity ?quantity;" + 
						"        com:unitPrice ?unitPrice;" + 
						"        com:fulfilledBy ?shipment." + 
						"    ?shipment com:consignee <urn:uuid:448c5299-b858-4eb1-bc55-0a7a6c04efee>;" + 
					    "        com:shipmentRef ?shipmentRef." + 
						"    OPTIONAL {" + 
					    "        ?shipment com:usesItem ?cow." + 
						"        OPTIONAL {" + 
					    "            ?cow com:ain ?ain." + 
						"            OPTIONAL {" + 
						"                ?cow com:vaccination ?vaccination." + 
						"                ?vaccination com:vaccine ?vaccine." + 
						"            }" + 
						"        }" + 
					    "    }" + 
					    "}"
		);
		
		var exe = QueryExecutionFactory.create(query, dataset);
		var resultSet = exe.execSelect();

		ResultSetFormatter.output(System.out, resultSet, ResultsFormat.FMT_RS_XML);
	}
}
