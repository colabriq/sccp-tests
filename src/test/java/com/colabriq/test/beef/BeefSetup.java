package com.colabriq.test.beef;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class BeefSetup {
	public static class BeefStack {
		public final URI endpoint, engine;
		
		private BeefStack(String endpoint, String engine) {
			try {
				this.endpoint = new URI(endpoint);
				this.engine = new URI(engine);
			}
			catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public static Map<String, BeefStack> STACKS = new HashMap<>();
	
	static {
		STACKS.put("RETAILER-0000000000",	new BeefStack("http://localhost:8081", "http://localhost:8091"));
		
		STACKS.put("FARMER-0000000000",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000001",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000002",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000003",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000004",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000005",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("FARMER-0000000006",		new BeefStack("http://localhost:8082", "http://localhost:8092"));
		
		STACKS.put("PROCESSOR-0000000000",	new BeefStack("http://localhost:8082", "http://localhost:8092"));
		STACKS.put("PROCESSOR-0000000001",	new BeefStack("http://localhost:8082", "http://localhost:8092"));
	}
}
