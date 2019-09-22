package com.colabriq.test.beef;

import static com.colabriq.shared.ConfigLoader.loadConfig;

import com.colabriq.engine.EngineModule;
import com.colabriq.shared.LogConfigurer;

/** launches an endpoint that loads the beef turtle files directly */
public class BeefDemoEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BeefDemoEndpoint.class, "log4j.debug.properties");
		
//		var endpointConfig = loadConfig(BeefDemoEndpoint.class, "beef/local.properties");
//		new EndpointModule(endpointConfig).start();
		
		var engineConfig = loadConfig(BeefDemoEndpoint.class, "beef/engine.properties");
		new EngineModule(engineConfig).start();
	}
}
