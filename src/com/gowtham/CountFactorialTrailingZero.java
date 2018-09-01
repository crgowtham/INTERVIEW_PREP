package com.gowtham;

public class CountFactorialTrailingZero {

	/*
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 * Example 1:
	 * 
	 * Input: 3 Output: 0 Explanation: 3! = 6, no trailing zero.
	 * 
	 * Let me give a better explanation that why we have to divide 5 first.
	 * There are 2 numbers can contribute trailing 0 each 10 numbers (5, 10| 15,
	 * 20| 25, 30|...).So we divide 10 and times 2. Then, 25 have one more
	 * contribution than 5, 125 have one more contribution than 25 ...
	 */

	public static int trailingZeroes(int n) {
		return n < 5 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static void main(String[] args) {
		System.out.println("TrailZero: " + trailingZeroes(100));
	}
}
