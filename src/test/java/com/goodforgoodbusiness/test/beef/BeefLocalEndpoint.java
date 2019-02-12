package com.goodforgoodbusiness.test.beef;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;
import static com.google.inject.Guice.createInjector;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.endpoint.rdf.RDFPreloader;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.test.module.EngineTestRunner;
import com.goodforgoodbusiness.webapp.Webapp;

/** launches an endpoint that loads the beef turtle files directly */
public class BeefLocalEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BeefLocalEndpoint.class, "log4j.debug.properties");
		
		var config = loadConfig(EngineTestRunner.class, "beef/local.properties");
		// override the preload.path with one computed relative to the classpath
		config.setProperty("preload.path", BeefLocalEndpoint.class.getClassLoader().getResource("beef/test/generated_claims").getFile());
		
		var injector = createInjector(new EndpointModule(config));
		
		injector.getInstance(RDFPreloader.class).preload();
		injector.getInstance(Webapp.class).start();
	}
}
