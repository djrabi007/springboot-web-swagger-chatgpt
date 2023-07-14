package com.javatpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.model.Movie;
import com.javatpoint.service.MovieService;
import com.javatpoint.util.PaginationUtil;

@Controller
public class MovieController {
	private final MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	/**
	 * 1)ADD add-movie.html ==>POST(/movies)==>movie-data.html (show single entry)
	 * 2)GET(movies/movies-top)==>movies.html(show the list of movies) 3)
	 * 3)GET(movies-page)==>movies-page.html(next,previous)
	 * 
	 * @return
	 */
	@GetMapping("/add-movie")
	public String showAddMovieForm() {
		return "add-movie";
	}

	@PostMapping("/movies")
	public ModelAndView addMovie(Movie movie) {
		movieService.addMovie(movie);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("movie-data-single");
		modelAndView.addObject("movie", movie);

		return modelAndView;

		// return "redirect:/add-movie";
	}

	@GetMapping("/movies")
	public String showMovies(Model model) {
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}

	/**
	 * // Sort movies by rating in descending order In this example, the movies are
	 * sorted based on their ratings in descending order using sorted(). The limit()
	 * function is then used to limit the stream to the top N movies with the
	 * highest ratings. Finally, the top-rated movies are collected into a list and
	 * displayed.
	 * 
	 * @param model
	 * @return
	 */

	@GetMapping("/movies-top")
	public String showMoviesTop(Model model) {
		int topN = 3;
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", PaginationUtil.getTopRatedMovies(topN, movies));
		return "movies";
	}
	// TODO -Need to implement



	@GetMapping("/movies-page")
	public String showMovies(Model model, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "3") int size) {
		Page<Movie> moviePage = movieService.getMovies(PageRequest.of(page - 1, size));
		model.addAttribute("movies", moviePage.getContent());
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", moviePage.getTotalPages());
		model.addAttribute("pages", PaginationUtil.getPaginationList(moviePage.getTotalPages()));
		return "movies-page";
	}



	@GetMapping("/home")
	public String showHomePage() {
		return "redirect:/movies";
	}

	@GetMapping("/main")
	public String showMainHomePage() {
		return "redirect:/add-movie";
	}
}
