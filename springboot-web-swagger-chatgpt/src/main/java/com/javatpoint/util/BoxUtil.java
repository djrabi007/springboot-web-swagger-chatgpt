package com.javatpoint.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BoxUtil {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 4, 5 };

		// Convert int array to List<Integer> using boxed()
		List<Integer> integerList = Arrays.stream(numbers).boxed().collect(Collectors.toList());

		// Print the List<Integer>
		System.out.println(integerList);

	}
}
