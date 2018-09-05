package com.gowtham;

public class IntegerReplace {

	/*
	 * Given a positive integer n and you can do operations as follow:
	 * 
	 * If n is even, replace n with n/2. If n is odd, you can replace n with
	 * either n + 1 or n - 1. What is the minimum number of replacements needed
	 * for n to become 1?
	 * 
	 * Example 1:
	 * 
	 * Input: 8
	 * 
	 * Output: 3
	 * 
	 * Explanation: 8 -> 4 -> 2 -> 1
	 */

	public int integerReplacement(int n) {
		if (n == Integer.MAX_VALUE)
			return 32; // n = 2^31-1;
		int count = 0;
		while (n > 1) {
			if (n % 2 == 0)
				n /= 2;
			else {
				if ((n + 1) % 4 == 0 && (n - 1 != 2))
					n++;
				else
					n--;
			}
			count++;
		}
		return count;
	}
}
