package com.gowtham;

public class LeetCodelengthOfLongestSubstring {
	
//	/Given a string, find the length of the longest substring without repeating characters. For
//	example, the longest substring without repeating letters for “abcabcbb” is “abc”, which
//	the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.

	public int lengthOfLongestSubstring(String s) {
		boolean[] exist = new boolean[256];
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			while (exist[s.charAt(j)]) {
				exist[s.charAt(i)] = false;
				i++;
			}
			exist[s.charAt(j)] = true;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

}
