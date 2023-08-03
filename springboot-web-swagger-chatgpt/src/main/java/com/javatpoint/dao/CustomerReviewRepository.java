package com.javatpoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.CustomerReview;

public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {
	// Add custom queries or methods if needed
}
