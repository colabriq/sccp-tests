package com.colabriq.test.beef;

import static com.colabriq.shared.ConfigLoader.loadConfig;

import com.colabriq.endpoint.EndpointModule;
import com.colabriq.shared.LogConfigurer;

/** launches an endpoint that loads the beef turtle files directly */
public class BeefEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BeefEndpoint.class, "log4j.debug.properties");	
		
		var rdfConfig = loadConfig(BeefEndpoint.class, "beef/endpoint.properties");
		var rdfModule = new EndpointModule(rdfConfig);
		rdfModule.start();
	}
}
