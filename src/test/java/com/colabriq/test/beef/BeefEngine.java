package com.colabriq.test.beef;

import static com.colabriq.shared.ConfigLoader.loadConfig;

import com.colabriq.engine.EngineModule;
import com.colabriq.shared.LogConfigurer;

public class BeefEngine {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BeefEndpoint.class, "log4j.debug.properties");	
		
		var engConfig = loadConfig(BeefEngine.class, "beef/engine.properties");
		var engModule = new EngineModule(engConfig);
		engModule.start();
	}
}
