package com.goodforgoodbusiness.test.berlin;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;

import java.net.URI;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.engine.EngineModule;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.shared.TimingRecorder;
import com.goodforgoodbusiness.test.module.EndpointTestRunner;
import com.goodforgoodbusiness.test.module.EngineTestRunner;

/** launches an endpoint that loads the beef turtle files directly */
public class BerlinTest {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BerlinTest.class, "log4j.info.properties");
		TimingRecorder.startLogging();
		
		// start components
		
		var engConfig1 = loadConfig(EngineTestRunner.class, "berlin/engine-1.properties");
		new EngineModule(engConfig1).start();		
		
		var endUrl1 = new URI("http://localhost:8081");
		var endConfig1 = loadConfig(EndpointTestRunner.class, "berlin/endpoint-1.properties");
		new EndpointModule(endConfig1).start();
		
//		// load dataset
//		var rootDir = new File("/Users/ijmad/Downloads/bsbmtools-0.2/dataset");
//		
//		var uploader = new TurtleUploader(rootDir) {
//			@Override
//			protected URI getEndpoint(String filename) {
//				return endUrl1;
//			}
//		};
//		
//		uploader.run();
	}
}

