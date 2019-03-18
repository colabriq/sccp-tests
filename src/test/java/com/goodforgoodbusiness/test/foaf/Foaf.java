package com.goodforgoodbusiness.test.foaf;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;
import static com.google.inject.Guice.createInjector;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.commons.configuration2.Configuration;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.endpoint.dht.ContainerCollector;
import com.goodforgoodbusiness.endpoint.dht.DHTSubmitter;
import com.goodforgoodbusiness.endpoint.rdf.RDFRunner;
import com.goodforgoodbusiness.endpoint.route.SparqlRoute;
import com.goodforgoodbusiness.endpoint.route.dht.DHTSparqlRoute;
import com.goodforgoodbusiness.shared.URIModifier;
import com.goodforgoodbusiness.test.SparqlTester;
import com.goodforgoodbusiness.webapp.ContentType;

public class Foaf {
	public static String ENDPOINT_ONLY = "endpoint-only/empty.properties";
	
	public static String ENGINE_1 = "dual/engine-1.properties";
	public static String ENDPOINT_1 = "dual/endpoint-1.properties";
	
	public static String ENGINE_2 = "dual/engine-2.properties";
	public static String ENDPOINT_2 = "dual/endpoint-2.properties";
	
	public static Configuration getConfig(String configFile) throws Exception {
		return loadConfig(Foaf.class, configFile);
	}
	
	public static SparqlTester newRunner(String configFile) throws Exception {
		var config = getConfig(configFile);
		var injector1 = createInjector(new EndpointModule(config));
		
		if (config.getBoolean("dht.enabled")) {
			return new SparqlTester(
				new DHTSparqlRoute(
					injector1.getInstance(ContainerCollector.class),
					injector1.getInstance(RDFRunner.class),
					injector1.getInstance(DHTSubmitter.class)
				)
			);
		}
		else {
			return new SparqlTester(
				new SparqlRoute(
					injector1.getInstance(RDFRunner.class)
				)
			);
		}
	}
		

	
	public static int getPort(String configFile) throws Exception {
		var config = loadConfig(Foaf.class, configFile);
		return config.getInt("port");
	}
	
	public static void shareKeys(String from, String to, String sub, String pre, String obj) throws Exception {
		// run with separate runners, as if the system was restarted.
		
		var cfgFrom = loadConfig(Foaf.class, from);
		var cfgTo = loadConfig(Foaf.class, to);

		// request a share key from Engine A
		var httpClient = HttpClient.newBuilder().build();

		var uri = URIModifier.from(new URI(cfgFrom.getString("dht.uri") + "/share"));
		
		if (sub != null) uri.addParam("sub", sub);
		if (pre != null) uri.addParam("pre", pre);
		if (obj != null) uri.addParam("obj", obj);
		
		var requestFrom = HttpRequest
			.newBuilder(uri.build())
			.header("Content-Type", ContentType.json.getContentTypeString())
			.GET()
			.build();
			
		var responseFrom = httpClient.send(requestFrom, BodyHandlers.ofString());
		
		if (responseFrom.statusCode() != 200) {
			throw new Exception("A: " + responseFrom.statusCode());
		}
		
		// send it back in to Engine B
		var requestTo = HttpRequest
				.newBuilder(new URI(cfgTo.getString("dht.uri") + "/share"))
				.header("Content-Type", ContentType.json.getContentTypeString())
				.POST(BodyPublishers.ofString(responseFrom.body()))
				.build();
			
		var responseTo = httpClient.send(requestTo, BodyHandlers.ofString());
		
		if (responseTo.statusCode() != 200) {
			throw new Exception("B: " + responseTo.statusCode());
		}
	}
}
