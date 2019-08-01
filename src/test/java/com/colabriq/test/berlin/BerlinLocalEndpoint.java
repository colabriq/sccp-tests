package com.goodforgoodbusiness.test.berlin;

import static com.goodforgoodbusiness.shared.ConfigLoader.loadConfig;

import com.goodforgoodbusiness.endpoint.EndpointModule;
import com.goodforgoodbusiness.shared.LogConfigurer;
import com.goodforgoodbusiness.shared.TimingRecorder;

/** launches an endpoint that loads the beef turtle files directly */
public class BerlinLocalEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BerlinLocalEndpoint.class, "log4j.info.properties");
		
		TimingRecorder.startLogging();
		
		var config = loadConfig(BerlinLocalEndpoint.class, "berlin/local.properties");
		new EndpointModule(config).start();
	}
}
