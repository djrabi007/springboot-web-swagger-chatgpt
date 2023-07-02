package com.javatpoint.util;

/**
 * use automation and intelligent algorithms to achieve time and effort savings
 * in a retail banking loan division:
 * 
 * @author rabi0
 *
 */


import java.util.ArrayList;
import java.util.List;

import com.javatpoint.model.Customer;


public class LoanProcessing {
	public static void main(String[] args) {
		// Create a list of customers
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("John Doe", 60000, 720));
		customers.add(new Customer("Alice Smith", 50000, 700));
		customers.add(new Customer("Bob Johnson", 40000, 660));

		// Process loan applications using the loan processing system
		LoanProcessingSystem.processLoanApplications(customers);
	}
}
