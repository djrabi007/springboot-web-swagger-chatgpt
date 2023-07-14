package com.javatpoint.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.javatpoint.model.Movie;
import com.javatpoint.model.Product;

public class PaginationUtil {

	public static void main(String[] args) {
		int pageNumber = 2; // The current page number
		int pageSize = 4; // The number of products per page

		System.out.println("########### Before  Pagination ############");
		List<Product> productList = fetchAllProducts(); // Retrieve all products

		List<Product> currentPageProducts = productList.stream().skip((pageNumber - 1) * pageSize) // Skip the products
																									// on previous pages
				.limit(pageSize) // Limit the number of products on the current page
				.collect(Collectors.toList());
		System.out.println("########### After  Pagination ############");

		// Display the current page products
		for (Product product : currentPageProducts) {
			System.out.println(product.getName());
		}
	}

	private static List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub

		// Sample list of products
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, "iPhone", 999.99));
		products.add(new Product(2, "Samsung Galaxy", 799.99));
		products.add(new Product(3, "Google Pixel1", 699.99));
		products.add(new Product(4, "Google Pixel2", 699.98));
		products.add(new Product(5, "Google Pixel3", 699.97));
		products.add(new Product(6, "Google Pixel4", 699.96));
		products.add(new Product(7, "Google Pixel5", 699.95));
		products.add(new Product(8, "Google Pixel6", 699.95));
		products.add(new Product(9, "Google Pixel5", 699.95));
		products.add(new Product(10, "Google Pixel7", 699.95));

		// Print the list of products
		for (Product product : products) {
			System.out.println(product);
		}
		return products;
	}

	/**
	 * convert int[] into Integer<List>
	 * 
	 * @param totalPages
	 * @return
	 */
	public static List<Integer> getPaginationList(int totalPages) {
		return IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
	}

	public static List<Movie> getTopRatedMovies(int topN, List<Movie> movies) {
		return movies.stream().sorted(Comparator.comparingDouble(Movie::getRating).reversed()) // Sort
				.limit(topN) // Limit the stream to the top N movies
				.collect(Collectors.toList());
	}
}
