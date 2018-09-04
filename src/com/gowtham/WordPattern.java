package com.gowtham;

public class WordPattern {

	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Example 1:
	 * 
	 * Input: pattern = "abba", str = "dog cat cat dog" Output: true
	 */

	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length())
			return false;
		Map index = new HashMap();
		for (Integer i = 0; i < words.length; ++i)
			if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
				return false;
		return true;
	}

}
