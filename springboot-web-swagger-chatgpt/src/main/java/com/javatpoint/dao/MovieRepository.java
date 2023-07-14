package com.javatpoint.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatpoint.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	// Custom query methods can be defined here if needed
}
