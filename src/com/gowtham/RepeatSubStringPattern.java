package com.gowtham;

public class RepeatSubStringPattern {

	/*
	 * Given a non-empty string check if it can be constructed by taking a
	 * substring of it and appending multiple copies of the substring together.
	 * You may assume the given string consists of lowercase English letters
	 * only and its length will not exceed 10000.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: "abab" Output: True Explanation: It's the substring "ab" twice.
	 * 
	 */

	public boolean repeatedSubstringPattern(String str) {
		String s = str + str;
		return s.substring(1, s.length() - 1).contains(str);
	}
}
