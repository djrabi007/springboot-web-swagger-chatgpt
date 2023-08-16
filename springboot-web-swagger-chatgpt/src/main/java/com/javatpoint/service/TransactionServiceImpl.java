package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.dao.TransactionRepository;
import com.javatpoint.model.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getTransactionsByCategory(String category) {
		return transactionRepository.findByCategory(category);
	}

	// Other service methods if needed
}
