package com.javatpoint.util;

import com.javatpoint.model.Customer;
import com.javatpoint.model.LoanRecommendation;

public class LoanRecommendationSystem {

	public static LoanRecommendation getLoanRecommendation(Customer customer) {
		// Rule-based logic to generate loan recommendations based on customer
		// attributes
		if (customer.getCreditScore() >= 700 && customer.getIncome() > 50000) {
			return new LoanRecommendation("Personal Loan", 10000, 8.5);
		} else if (customer.getCreditScore() >= 650 && customer.getIncome() > 40000) {
			return new LoanRecommendation("Car Loan", 20000, 6.5);
		} else {
			return new LoanRecommendation("No Recommendation", 0, 0);
		}
	}

}
