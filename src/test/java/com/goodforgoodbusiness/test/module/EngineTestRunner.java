package com.goodforgoodbusiness.test.module;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;
import static com.google.inject.Guice.createInjector;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.webapp.Webapp;

public class EngineTestRunner {
	public static void main(String[] args) throws Exception {
		var config = loadConfig(EngineTestRunner.class, args[0]);
		LogConfigurer.init(EngineTestRunner.class, config.getString("log.properties", "log4j.debug.properties"));
		
		var injector = createInjector(new EndpointModule(config));
		injector.getInstance(Webapp.class).start();
	}
}
