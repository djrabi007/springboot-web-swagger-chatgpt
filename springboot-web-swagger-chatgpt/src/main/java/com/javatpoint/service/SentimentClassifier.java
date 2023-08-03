package com.javatpoint.service;

import java.util.List;
import java.util.Map;

import com.javatpoint.model.CustomerReview;

public interface SentimentClassifier {
	String predict(String text);
	// public Map<String, Integer> calculateSentimentDistribution(List<String>
	// reviews);

	Map<String, Integer> calculateSentimentDistributionByCustomer(List<CustomerReview> reviews);
}
