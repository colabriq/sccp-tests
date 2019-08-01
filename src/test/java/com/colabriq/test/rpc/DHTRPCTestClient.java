package com.colabriq.test.rpc;

import java.util.Random;
import java.util.stream.Stream;

import com.colabriq.endpoint.dht.backend.impl.DHTRPCBackend;
import com.colabriq.rpclib.client.RPCWebClientCreator;
import com.colabriq.shared.LogConfigurer;
import com.colabriq.webapp.VertxProvider;

import io.vertx.core.Future;

public class DHTRPCTestClient {
	private static int POINTER_PATTERN_SZ = 128;
	private static int POINTER_DATA_SZ = 400;
	
	private static final Random random = new Random();
	
	public static void main(String[] args) throws Exception {
		LogConfigurer.init(DHTRPCTestClient.class, "log4j.debug.properties");
		
		var vertx = new VertxProvider().get();
		var client = RPCWebClientCreator.create(vertx);
		var backend = new DHTRPCBackend(vertx, client, "http://localhost:8091");
		
		var id = "fc4c3708119d3170d16d4ff53fb6b11bb42bbf447b822409ad80c4032b47df57fa81ea5266dfd2fca2351d95f91694706cd64ec5f86e488f35b5f4df0dbec2c7";
		var container1 = new byte[3000];
		
		backend.publishContainer(id, container1, Future.<String>future().setHandler(result -> {
			System.out.println("PUBLISHED: " + result.result());
		}));
		
//		// this is a representative pointer size and a real pattern size
//		var pattern1 = createPattern(POINTER_PATTERN_SZ);
//		var pointer1 = new byte[POINTER_DATA_SZ];
		
//		random.nextBytes(pointer1);
//		backend.publishPointer(pattern1, pointer1, Future.<Void>future().setHandler(result -> {
//			System.out.println("PUBLISHED!");
//		}));
//		
//		var pointer2 = new byte[POINTER_DATA_SZ];
//		random.nextBytes(pointer2);
//		backend.publishPointer(pattern1, pointer2, Future.<Void>future().setHandler(result -> {
//			System.out.println("PUBLISHED!");
//		}));
//		
//		for (int i = 0; i < 10; i++) {
//			final int ii = i;
//			
//			backend.searchForPointers(pattern1, Future.<Stream<byte[]>>future().setHandler(result -> {
//				System.out.println("returned " + ii);
//				
//				if (result.succeeded()) {
//					result.result().forEach(arr -> {
//						System.out.println("result");
//					});
//				}
//				else {
//					result.cause().printStackTrace();
//				}
//			}));
//		}
	}
	

	public static String createPattern(int length) {
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length) {
			sb.append(Integer.toHexString(random.nextInt()));
		}
		
		return sb.toString();
	}
}


