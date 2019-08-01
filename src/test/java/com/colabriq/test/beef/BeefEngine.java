package com.goodforgoodbusiness.test.beef;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;

import com.goodforgoodbusiness.engine.EngineModule;
import com.goodforgoodbusiness.shared.LogConfigurer;

public class BeefEngine {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BeefEndpoint.class, "log4j.debug.properties");	
		
		var engConfig = loadConfig(BeefEngine.class, "beef/engine.properties");
		var engModule = new EngineModule(engConfig);
		engModule.start();
	}
}
