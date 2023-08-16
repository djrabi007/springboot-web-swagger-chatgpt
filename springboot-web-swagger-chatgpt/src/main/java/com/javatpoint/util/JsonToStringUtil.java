package com.javatpoint.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToStringUtil {
	public static void main(String[] args) throws Exception {
		// jsonToStringExample();

		Map<String, Integer> sentimentDistribution = new HashMap<>();
		sentimentDistribution.put("Positive", 0);
		sentimentDistribution.put("Negative", 0);
		sentimentDistribution.put("Neutral", 0);

		String sentiment = "Negative";
		sentimentDistribution.put(sentiment, sentimentDistribution.get(sentiment) + 1);
		System.out.println(sentimentDistribution);

	}

	private static void jsonToStringExample() throws IOException {
		String inputJson = "{\"review\":\"very good!!\"}";
		String st = jsonToString(inputJson, "review");
		System.out.println("st =" + st);
	}

	public static String jsonToString(String review, String fieldname) throws IOException {
		// Create an ObjectMapper to parse JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(review);

		// Get the value of the "review" field
		String reviewStr = rootNode.get(fieldname).asText();
		return reviewStr;
	}
}
