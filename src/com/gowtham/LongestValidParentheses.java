package com.gowtham;

public class LongestValidParentheses {

	public int longestValidParentheses(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(-1);
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(') {
				st.push(i);
			} else {

				st.pop();
				if (!st.isEmpty()) {
					res = Math.max(res, i - st.peek());
				} else {
					st.push(i);
				}
			}
		}

		return res;
	}
}
