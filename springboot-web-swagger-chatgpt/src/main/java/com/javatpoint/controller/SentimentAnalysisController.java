package com.javatpoint.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatpoint.dao.CustomerReviewRepository;
import com.javatpoint.model.CustomerReview;
import com.javatpoint.service.SentimentClassifier;
import com.javatpoint.util.JsonToStringUtil;

//@RestController
@Controller
public class SentimentAnalysisController {
	@Autowired
	private SentimentClassifier sentimentClassifier;

	@Autowired
	private CustomerReviewRepository customerReviewRepository;

	/**
	 * // Implement any required data preprocessing here, like removing special //
	 * characters, converting to lowercase, etc.
	 * 
	 * // Perform sentiment analysis using the sentimentClassifier pom.xml entry
	 * groupId= com.fasterxml.jackson.core artifactId=jackson-databind
	 * 
	 * @param review
	 * @return
	 */

	@PostMapping("/analyzeSentiment")
	@ResponseBody
	public String analyzeSentiment(@RequestBody String review) throws Exception {
		// review= "{"review":"very good!!"}"
		// reviewStr= "very good!!"
		String reviewStr = JsonToStringUtil.jsonToString(review, "review");

		CustomerReview customerReview = new CustomerReview();
		customerReview.setReview(reviewStr);
		// Save the review to the H2 database
		customerReviewRepository.save(customerReview);

		// Predict the analysis result "positive","Negative","Neutral"
		String sentiment = sentimentClassifier.predict(reviewStr);

		return sentiment;
	}

//navigate to customer-review.html 
	@GetMapping("/customer-review")
	public String showCustomerReview() {
		return "customer-review";
	}

	// @ResponseBody
//	public List<CustomerReview> getAllReviews(Model model) throws Exception {
	@GetMapping("/getAllReviews")
	public String getAllReviews(Model model) throws Exception {
		// Fetch all customer reviews from the database
		List<CustomerReview> reviews = customerReviewRepository.findAll();
		Map<String, Integer> sentimentDistribution = sentimentClassifier
				.calculateSentimentDistributionByCustomer(reviews);
		model.addAttribute("reviewTotal", reviews);// list of sentences
		model.addAttribute("reviewSummary", sentimentDistribution); // count
		return "customer-review";
	}
}

