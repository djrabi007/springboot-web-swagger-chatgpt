package com.javatpoint.util;

import com.javatpoint.model.Customer;
import com.javatpoint.model.LoanRecommendation;

/**
 * generate personalized loan recommendations using a simple rule-based
 * approach:
 * 
 * Personalized Loan Recommendations: Using the trained models, the system can
 * generate personalized loan recommendations for each customer. The
 * recommendations can include loan types, amounts, interest rates, repayment
 * periods, and other relevant details.
 * 
 * @author rabi0
 *
 */

public class LoanMain {
	public static void main(String[] args) {
		// Create a customer object
		Customer customer = new Customer("John Doe", 60000, 720);

		getLoanRecommendation(customer);
	}

	public static LoanRecommendation getLoanRecommendation(Customer customer) {
		// Get loan recommendation for the customer
		LoanRecommendation recommendation = LoanRecommendationSystem.getLoanRecommendation(customer);

		// Display the recommendation
		if (recommendation.getLoanType().equals("No Recommendation")) {
			System.out.println("No loan recommendation available for " + customer.getName());
		} else {
			System.out.println("Loan Recommendation for " + customer.getName() + ":");
			System.out.println("Loan Type: " + recommendation.getLoanType());
			System.out.println("Loan Amount: $" + recommendation.getLoanAmount());
			System.out.println("Interest Rate: " + recommendation.getInterestRate() + "%");
		}
		return recommendation;
	}
}
