package com.javatpoint.model;

public class LoanRecommendation {

	private String loanType;
	private double loanAmount;
	private double interestRate;

	public LoanRecommendation(String loanType, double loanAmount, double interestRate) {
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
	}

	public String getLoanType() {
		return loanType;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

}
