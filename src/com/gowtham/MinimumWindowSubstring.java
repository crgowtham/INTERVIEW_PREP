package com.gowtham;

import java.util.HashMap;

//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

//For example,
//S = "ADOBECODEBANC"
//T = "ABC"
//Minimum window is "BANC".

//Note:
//If there is no such window in S that covers all characters in T, return the empty string "".

//If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] arr = new int[128];

		for (char c : t.toCharArray())
			arr[c]++;

		int count = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;

		while (end < s.length()) {
			if (arr[s.charAt(end++)]-- > 0)
				count--;
			while (count == 0) {
				if (end - begin < d) {
					d = end - begin;
					head = begin;
				}
				if (arr[s.charAt(begin++)]++ == 0)
					count++;
			}
		}

		return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);

	}
}