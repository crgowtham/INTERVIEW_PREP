package com.gowtham;

public class UglyNumber {

	/*
	 * Write a program to check whether a given number is an ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5.
	 * 
	 * Example 1:
	 * 
	 * Input: 6 Output: true Explanation: 6 = 2 × 3
	 */

	public Boolean uglyNo(int num) {
		for (int i = 2; i < 6 && num > 0; i++)
			while (num % i == 0)
				num /= i;
		return num == 1;
	}

}
