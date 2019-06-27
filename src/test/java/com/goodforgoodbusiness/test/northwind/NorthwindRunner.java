package com.goodforgoodbusiness.test.northwind;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.engine.EngineModule;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.test.module.EndpointTestRunner;
import com.goodforgoodbusiness.test.module.EngineTestRunner;

/** launches an endpoint that loads the beef turtle files directly */
public class NorthwindRunner {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(NorthwindRunner.class, "log4j.debug.properties");		
		
		var engineConfig = loadConfig(EngineTestRunner.class, "northwind/engine-1.properties");
		new EngineModule(engineConfig).start();
		
		var endpointConfig = loadConfig(EndpointTestRunner.class, "northwind/endpoint-1.properties");
		new EndpointModule(endpointConfig).start();
		
		var schemaConfig = loadConfig(EndpointTestRunner.class, "northwind/schema.properties");
		new EndpointModule(schemaConfig).start();
	}
}
