package com.gowtham;

public class LongestPalindromeBuild {

	/*
	 * Given a string which consists of lowercase or uppercase letters, find the
	 * length of the longest palindromes that can be built with those letters.
	 * 
	 * This is case sensitive, for example "Aa" is not considered a palindrome
	 * here.
	 * 
	 * Note: Assume the length of given string will not exceed 1,010.
	 * 
	 * Example:
	 * 
	 * Input: "abccccdd"
	 * 
	 * Output: 7
	 * 
	 * Explanation: One longest palindrome that can be built is "dccaccd", whose
	 * length is 7.
	 */

	public int longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Set<Character> set = new HashSet<>();
		int len = 0;
		for (char c : s.toCharArray()) {
			if (set.remove(c))
				len += 2;
			else
				set.add(c);
		}
		return set.size() > 0 ? len + 1 : len;
	}
}
