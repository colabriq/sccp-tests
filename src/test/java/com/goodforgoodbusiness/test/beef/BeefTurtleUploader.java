//package com.goodforgoodbusiness.test.beef;
//
//import java.io.File;
//import java.net.URI;
//
//import com.goodforgoodbusiness.utils.ingest.TurtleUploader;
//
//public class BeefTurtleUploader extends TurtleUploader {
//	protected BeefTurtleUploader(File rootDir) {
//		super(rootDir);
//	}
//
//	@Override
//	protected URI getEndpoint(String filename) {
//		// actor determines endpoint
//		return BeefSetup.STACKS.get(filename.split("_")[1]).endpoint;
//	}
//	
//	public static void main(String[] args) throws Exception {
//		var path = new File(BeefTurtleUploader.class.getClassLoader().getResource("beef/test/generated_claims").getFile());
//		new BeefTurtleUploader(path).run();
//	}
//}
