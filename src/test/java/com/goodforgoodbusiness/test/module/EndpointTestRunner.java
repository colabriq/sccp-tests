package com.goodforgoodbusiness.test.module;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;
import static com.google.inject.Guice.createInjector;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.endpoint.rdf.RDFPreloader;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.webapp.Webapp;

public class EndpointTestRunner {
	public static void main(String[] args) throws Exception {
		var config = loadConfig(EndpointTestRunner.class, args[0]);
		LogConfigurer.init(EndpointTestRunner.class, config.getString("log.properties", "log4j.info.properties"));
		
		var injector = createInjector(new EndpointModule(config));
		
		injector.getInstance(RDFPreloader.class).preload();
		injector.getInstance(Webapp.class).start();
	}
}
