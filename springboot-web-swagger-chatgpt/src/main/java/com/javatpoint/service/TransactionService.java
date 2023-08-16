package com.javatpoint.service;

import java.util.List;

import com.javatpoint.model.Transaction;

public interface TransactionService {

	List<Transaction> getTransactionsByCategory(String category);

	// Other service methods
}
