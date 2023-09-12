package com.javatpoint.util;

import java.util.ArrayList;
import java.util.List;

public class OlbNumberValidator {
	public static void main(String[] args) {
		List<String> olbNumbers = new ArrayList<>();
		// Add your list of OlbNumbers here
		olbNumbers.add("123");
		olbNumbers.add("E456");
		olbNumbers.add("E789");
		olbNumbers.add("E012");
		olbNumbers.add("E0199");
		olbNumbers.add("E0198");
		olbNumbers.add("345");
		olbNumbers.add("678");
		olbNumbers.add("E901");
		olbNumbers.add("234");
		olbNumbers.add("E567");
		olbNumbers.add("E890");

		int consecutiveWrongCount = 0;
		int maxConsecutiveWrong = 5; // Maximum allowed consecutive wrong OlbNumbers

		for (String olbNumber : olbNumbers) {
			if (olbNumber.startsWith("E")) {
				// This OlbNumber is wrong
				consecutiveWrongCount++;

				if (consecutiveWrongCount >= maxConsecutiveWrong) {
					// Throw an exception if the maximum consecutive wrong count is reached
					throw new IllegalStateException("Exceeded maximum consecutive wrong OlbNumbers");
				}
			} else {
				// Reset consecutive wrong count when a correct OlbNumber is encountered
				consecutiveWrongCount = 0;
			}
		}
	}
}
