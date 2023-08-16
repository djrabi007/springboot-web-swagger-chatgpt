package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatpoint.model.Transaction;
import com.javatpoint.service.TransactionServiceImpl;

/**
 * Bank customer is spending money in different sector like
 * Fashion,Retail,Grocery,Electronics. They are stored in H2 Database based on
 * Transaction category. SpringBoot application need to show the transaction
 * pattern of Customer.
 * 
 * @author rabi0
 *
 */
@Controller
public class TransactionController {

	@Autowired
	private TransactionServiceImpl transactionService;



	@RequestMapping("/transaction-pattern")
	public String showTransactionPattern(Model model) {
		List<Transaction> fashionTransactions = transactionService.getTransactionsByCategory("Fashion");
		List<Transaction> retailTransactions = transactionService.getTransactionsByCategory("Retail");
		List<Transaction> groceryTransactions = transactionService.getTransactionsByCategory("Grocery");
		List<Transaction> electronicsTransactions = transactionService.getTransactionsByCategory("Electronics");

		List<Double> amounts = new ArrayList<>();
		amounts.add(calculateTotalAmount(fashionTransactions));
		amounts.add(calculateTotalAmount(retailTransactions));
		amounts.add(calculateTotalAmount(groceryTransactions));
		amounts.add(calculateTotalAmount(electronicsTransactions));

		model.addAttribute("categories", Arrays.asList("Fashion", "Retail", "Grocery", "Electronics"));
		model.addAttribute("amounts", amounts);

		return "transaction-pattern";
	}

	private double calculateTotalAmount(List<Transaction> transactions) {
		return transactions.stream().mapToDouble(Transaction::getAmount).sum();
	}
}
