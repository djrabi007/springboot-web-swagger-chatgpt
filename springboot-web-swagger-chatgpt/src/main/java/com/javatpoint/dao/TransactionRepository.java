package com.javatpoint.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByCategory(String category);

	// Other queries as needed
}
