package com.colabriq.test.berlin;

import static com.colabriq.shared.ConfigLoader.loadConfig;

import com.colabriq.endpoint.EndpointModule;
import com.colabriq.shared.LogConfigurer;
import com.colabriq.shared.TimingRecorder;

/** launches an endpoint that loads the beef turtle files directly */
public class BerlinLocalEndpoint {
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(BerlinLocalEndpoint.class, "log4j.info.properties");
		
		TimingRecorder.startLogging();
		
		var config = loadConfig(BerlinLocalEndpoint.class, "berlin/local.properties");
		new EndpointModule(config).start();
	}
}
