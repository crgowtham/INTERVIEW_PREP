package com.gowtham;

public class PalaindromeParitioning {

	/*
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * Example:
	 * 
	 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
	 */

	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<>();
		dfs(res, new LinkedList<>(), s);
		return res;
	}

	void dfs(List<List<String>> res, LinkedList<String> lis, String s) {
		if (s.equals("")) {
			res.add(new LinkedList<>(lis));
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i + 1);
			if (isPal(0, i, s)) {
				lis.add(left);
				dfs(res, lis, s.substring(i + 1));
				lis.remove(lis.size() - 1);
			}
		}
	}

	boolean isPal(int left, int right, String s) {
		while (left < right)
			if (s.charAt(left++) != s.charAt(right--))
				return false;
		return true;
	}
}
