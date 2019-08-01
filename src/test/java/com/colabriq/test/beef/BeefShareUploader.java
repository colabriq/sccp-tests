//package com.goodforgoodbusiness.test.beef;
//
//import static com.goodforgoodbusiness.test.beef.BeefSetup.STACKS;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.net.URI;
//
//import com.goodforgoodbusiness.utils.ingest.ShareUploader;
//
//public class BeefShareUploader extends ShareUploader {			
//	protected BeefShareUploader(File shareFile) throws FileNotFoundException, IOException {
//		super(shareFile);
//	}
//	
//	@Override
//	protected URI getToEngine(String infoCreator) {
//		// always share with the retailer
//		return STACKS.get("RETAILER-0000000000").engine;
//	}
//	
//	@Override
//	protected URI getFromEngine(String infoCreator) {
//		if (STACKS.containsKey(infoCreator)) {
//			return STACKS.get(infoCreator).engine;
//		}
//		else {
//			// handle non-fatally.
//			System.err.println("Skipping share statements for " + infoCreator + " (unknown actor)");
//			return null;
//		}
//	}
//	
//	public static void main(String[] args) throws Exception {
//		var sharesFile = new File(BeefShareUploader.class.getClassLoader().getResource("beef/test/shares.json").getFile());
//		new BeefShareUploader(sharesFile).run(false);
//	}
//}
