package com.gowtham;

public class StringDifference {
	
	public static void main(String[] args) {
		System.out.println("Difference: " + findTheDifference("abcd", "adcbe"));
	}

	public static char findTheDifference(String s, String t) {

		int charCodeS = 0;
		int charCodeT = 0;

		for (int i = 0; i < s.length(); i++) {

			charCodeS += (int) (s.charAt(i));

		}

		for (int i = 0; i < t.length(); i++) {

			charCodeT += (int) (t.charAt(i));

		}

		return (char) (charCodeT - charCodeS);

	}

}
