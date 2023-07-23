package com.javatpoint.util;

import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializationExample {
	public static void main(String[] args) {
		String jsonString = "[\"value1\", \"value2\", \"value3\"]";

		try {
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<String> dataList = mapper.readValue(jsonString, new TypeReference<ArrayList<String>>() {
			});

			System.out.println("Deserialized ArrayList: " + dataList);
		} catch (Exception e) {
			System.out.println("Error occurred during deserialization: " + e.getMessage());
		}
	}
}

