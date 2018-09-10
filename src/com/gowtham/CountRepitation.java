package com.gowtham;

public class CountRepitation {

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int M = 0, p = 0, q = 0;

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) == s2.charAt(q)) {
					q++;

					if (q == s2.length()) {
						p++;
						q = 0;
					}

					if (p == n2) {
						M++;
						p = 0;
					}
				}
			}
		}

		return M;
	}

}
