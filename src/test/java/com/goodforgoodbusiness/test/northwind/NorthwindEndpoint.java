package com.goodforgoodbusiness.test.northwind;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;

import java.net.URI;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.engine.EngineModule;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.test.module.EndpointTestRunner;
import com.goodforgoodbusiness.test.module.EngineTestRunner;

/** launches an endpoint that loads the beef turtle files directly */
public class NorthwindEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(NorthwindEndpoint.class, "log4j.debug.properties");		
		
		// start components
		
		var engConfig1 = loadConfig(EngineTestRunner.class, "northwind/engine-1.properties");
		new EngineModule(engConfig1).start();		
		
		var endUrl1 = new URI("http://localhost:8081");
		var endConfig1 = loadConfig(EndpointTestRunner.class, "northwind/endpoint-1.properties");
		new EndpointModule(endConfig1).start();
	}
}
