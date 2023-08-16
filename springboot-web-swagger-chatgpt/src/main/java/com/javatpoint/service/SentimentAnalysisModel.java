package com.javatpoint.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.javatpoint.model.CustomerReview;
import com.javatpoint.util.RabiUtil;

/**
 * Here's a real-life example of a sentiment analysis model implemented in Java
 * for predicting sentiment in customer reviews. For simplicity, we'll use a
 * basic approach with a predefined lexicon of positive and negative words.
 * 
 * @author rabi0
 *
 */
@Service
public class SentimentAnalysisModel implements SentimentClassifier {

	private final Set<String> positiveWords;
	private final Set<String> negativeWords;

	public SentimentAnalysisModel() {
		// Initialize positive and negative word sets from a predefined lexicon
		positiveWords = new HashSet<>();
		positiveWords.add("good");
		positiveWords.add("Good");
		positiveWords.add("excellent");
		positiveWords.add("love");
		positiveWords.add("Great");
		positiveWords.add("satisfied");
		positiveWords.add("amazing");
		positiveWords.add("nice");
		positiveWords.add("like");
		positiveWords.add("awesome");
		positiveWords.add("fantastic");

		// Add more positive words as needed

		negativeWords = new HashSet<>();
		negativeWords.add("bad");
		negativeWords.add("poor");
		negativeWords.add("hate");
		negativeWords.add("disappointed");
		negativeWords.add("terrible");
		negativeWords.add("worst");
		// Add more negative words as needed
	}

	@Override
	public String predict(String text) {
		int positiveCount = 0;
		int negativeCount = 0;
		boolean isNotFlag = false;

		// Tokenize the text into words
		String[] words = RabiUtil.tokenizeText(text);

		// Calculate the sentiment score based on positive and negative word counts
		for (String word : words) {
			// Using regular expression to remove the trailing period
			// "terrible." into "terrible"
			String wordRemovTrailingperiod = RabiUtil.removeTrailingPunctuation(word);

			if (StringUtils.equalsAny(wordRemovTrailingperiod, "not", "don't")) {
				isNotFlag = true;
			}
			if (positiveWords.contains(wordRemovTrailingperiod) && !isNotFlag) { // "...stisfied"-->Positive
				positiveCount++;
			} else if (positiveWords.contains(wordRemovTrailingperiod) && isNotFlag) { // "...not satisfied" -->Negative
				negativeCount++;
			} else if (negativeWords.contains(wordRemovTrailingperiod) && !isNotFlag) {// "..bad"-->Negative
				negativeCount++;
			}
			else if (negativeWords.contains(wordRemovTrailingperiod) && isNotFlag) { // "...not bad"-->Positive
				positiveCount++;
			}
		}

		// Determine the sentiment based on the sentiment score
		if (positiveCount > negativeCount) {
			return "Positive";
		} else if (positiveCount < negativeCount) {
			return "Negative";
		} else {
			return "Neutral";
		}

		// Preprocess the text if needed (e.g., remove special characters, convert to
		// lowercase)

//		String removedPunctStr = removeTrailingPunctuation(text);
//		 if (StringUtils.containsIgnoreCase(removedPunctStr, "not")) {
//		if (removedPunctStr.contains("not") || removedPunctStr.contains("Not")) {
//			isNotFlag = true;
//		}
	}



//	private String removeFullStop(String word) {
//		return word.replaceAll("\\.$", "");
//	}





	public Map<String, Integer> calculateSentimentDistribution(List<String> reviews) {
		Map<String, Integer> sentimentDistribution = new HashMap<>();
		sentimentDistribution.put("Positive", 0);
		sentimentDistribution.put("Negative", 0);
		sentimentDistribution.put("Neutral", 0);

		for (String review : reviews) {
			String sentiment = predict(review);
			sentimentDistribution.put(sentiment, sentimentDistribution.get(sentiment) + 1);
		}

		return sentimentDistribution;
	}

	@Override
	public Map<String, Integer> calculateSentimentDistributionByCustomer(List<CustomerReview> reviews) {
		Map<String, Integer> sentimentDistribution = new HashMap<>();
		sentimentDistribution.put("Positive", 0);
		sentimentDistribution.put("Negative", 0);
		sentimentDistribution.put("Neutral", 0);

		for (CustomerReview custReview : reviews) {
			String sentiment = predict(custReview.getReview());
			sentimentDistribution.put(sentiment, sentimentDistribution.get(sentiment) + 1);
		}

		return sentimentDistribution;
	}


	private void removeLastSign() {
		String st = "It is terrible)$(";
		st = RabiUtil.removeTrailingPunctuation(st);
		System.out.println(st);
	}

	public static void main(String[] args) {
		// removeLastSign();
		SentimentAnalysisModel sentimentAnalysisModelV1 = new SentimentAnalysisModel();
		List<String> reviewsList = new ArrayList<String>();
		// positive-->good,excellent,love
		// Negative-->bad,poor,hate
		// Add some sample reviews to the list
		reviewsList.add("The product is amazing and works perfectly. I love it!");// Positive
		reviewsList.add("This service is terrible. I'm very disappointed.");// Negative
		reviewsList.add("Great customer support and quick response time.");// Positive
		reviewsList.add("Not worth the money. Very poor quality."); // Negative
		reviewsList.add("I'm not satisfied with my purchase. Highly recommended.");// Negative
		reviewsList.add("I'm  satisfied with my purchase. Highly recommended.");// Positive
		reviewsList.add("It is nott  very poor product");// Negative
		Map<String, Integer> sentimentDistribution = sentimentAnalysisModelV1
				.calculateSentimentDistribution(reviewsList);
		System.out.println(sentimentDistribution);
		
	}
}
