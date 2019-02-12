package com.goodforgoodbusiness.test.beef;

import java.util.Optional;

import com.goodforgoodbusiness.model.TriTuple;
import com.goodforgoodbusiness.utils.MatchesClient;

public class BeefMatchesTest {
	public static void main(String[] args) throws Exception {
		var client = new MatchesClient(8091);
		
		// test whether various triple matches can be fetched from Engine.
		// these should all produce results against the mini corpus.
		
//		var tt1 = new TriTuple(Optional.of("urn:uuid:7b8a2bd0-6f5c-4b91-8b4a-d8d90685d8d7"), Optional.of("https://schemas.goodforgoodbusiness.com/common-operating-model/lite/buyerRef"), Optional.empty());
//		System.out.println(client.matches(tt1));
//		
//		var tt2 = new TriTuple(Optional.of("urn:uuid:7b8a2bd0-6f5c-4b91-8b4a-d8d90685d8d7"), Optional.of("https://schemas.goodforgoodbusiness.com/common-operating-model/lite/quantity"), Optional.empty());
//		System.out.println(client.matches(tt2));
//		
//		var tt3 = new TriTuple(Optional.of("urn:uuid:7b8a2bd0-6f5c-4b91-8b4a-d8d90685d8d7"), Optional.of("https://schemas.goodforgoodbusiness.com/common-operating-model/lite/unitPrice"), Optional.empty());
//		System.out.println(client.matches(tt3));
		
		var tt4 = new TriTuple(Optional.of("urn:uuid:e20e44fd-a279-4e68-bf62-907b1f45815c"), Optional.of("https://schemas.goodforgoodbusiness.com/common-operating-model/lite/fulfilledBy"), Optional.empty());
		System.out.println(client.matches(tt4));
	}
}
