package com.gowtham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class LongestUniqueWord {

	/*
	 * do not initialize this class
	 */
	private LongestUniqueWord() {
	}

	/**
	 * Returns the longest non-repeating(unique) word in the list. If each word
	 * repeats then return null.
	 * 
	 * 
	 * @param words
	 *            the list of words of a news paper.
	 * @return the longest unique word.
	 * @throws IllegalArgumentException
	 *             if input size is 0.
	 * @throws NPE
	 *             if the input is null.
	 */
	public static String longestUniqueWord(List<String> words) {
		if (words.size() == 0)
			throw new IllegalArgumentException("The array should not be empty.");

		final Map<String, Boolean> uniqueWords = new HashMap<String, Boolean>();

		for (String word : words) {
			if (uniqueWords.containsKey(word)) {
				uniqueWords.put(word, false);
			} else {
				uniqueWords.put(word, true);
			}
		}

		int maxLength = 0;
		String longestUniqueWord = null;
		for (Map.Entry<String, Boolean> entry : uniqueWords.entrySet()) {
			if (entry.getValue() && entry.getKey().length() > maxLength) {
				longestUniqueWord = entry.getKey();
				maxLength = longestUniqueWord.length();
			}
		}

		return longestUniqueWord;
	}

	public static void main(String[] args) {
		List<String> newsPaper = new ArrayList<String>();
		newsPaper.add("Jack");
		newsPaper.add("In");
		newsPaper.add("In");
		newsPaper.add("The");
		newsPaper.add("The");
		newsPaper.add("Box");

		System.out.println("Expected: Jack, Actual: " + longestUniqueWord(newsPaper));

		newsPaper.add("Jack");
		System.out.println("Expected: Box, Actual: " + longestUniqueWord(newsPaper));
	}

	public static void calc(String str, int index) {
		if (index >= str.length())
			return;
		int temp_length = 0;
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		int longest_length = 0;
		for (int i = index; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), i);
				++temp_length;
			} else if (map.containsKey(str.charAt(i))) {
				if (longest_length < temp_length) {
					longest_length = temp_length;
				}
				int last_index = map.get(str.charAt(i));
				// System.out.println(last_index);
				calc(str, last_index + 1);
				break;
			}
		}
		if (longest_length < temp_length)
			longest_length = temp_length;
	}

}
