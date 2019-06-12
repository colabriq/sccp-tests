package com.goodforgoodbusiness.test.beef;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import com.goodforgoodbusiness.utils.ingest.TurtleUploader;

/**
 * Uploads all beef data in to a single endpoint.
 */
public class BeefSingleUploader extends TurtleUploader {
	protected BeefSingleUploader(File rootDir) {
		super(rootDir);
	}

	@Override
	protected URI getEndpoint(String filename) throws URISyntaxException {
		// actor determines endpoint
		return new URI("http://localhost:8081");
	}
	
	public static void main(String[] args) throws Exception {
		var path = new File(BeefSingleUploader.class.getClassLoader().getResource("beef/test/generated_claims").getFile());
		new BeefSingleUploader(path).run();
	}
}
