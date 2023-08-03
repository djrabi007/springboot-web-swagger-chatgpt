package com.javatpoint.util;

public class RabiUtil {

	/**
	 * Using regular expression to remove the trailing punctuation Remove special
	 * charater ".,!@#%^*$()-=" from String
	 **/
	public static String removeTrailingPunctuation(String inputString) {
		String result = inputString.replaceAll("[.,!@#%^*$()-=]+$", "");
		return result;
	}

	public static String[] tokenizeText(String text) {
		return text.split("\\s+");
	}

}
