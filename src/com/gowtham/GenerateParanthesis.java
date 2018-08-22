package com.gowtham;

public class GenerateParanthesis {
	/*
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new LinkedList<String>();
		DFS(res, "", 0, 0, n);
		return res;
	}

	public void DFS(List<String> res, String curr, int left, int right, int n) {
		if (left == n && right == n) {
			res.add(curr);
			return;
		}
		if (left < n) {
			DFS(res, curr + '(', left + 1, right, n);
		}
		if (right < left) {
			DFS(res, curr + ')', left, right + 1, n);

		}

	}
}
