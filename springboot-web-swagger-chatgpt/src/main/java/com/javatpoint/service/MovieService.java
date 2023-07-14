package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javatpoint.dao.MovieRepository;
import com.javatpoint.model.Movie;

@Service
public class MovieService {
	private final MovieRepository movieRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public Page<Movie> getMovies(Pageable pageable) {
		return movieRepository.findAll(pageable);
	}
}
