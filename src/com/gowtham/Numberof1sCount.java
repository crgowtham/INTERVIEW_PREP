package com.gowtham;

public class Numberof1sCount {

	/*
	 * Write a function that takes an unsigned integer and returns the number of
	 * '1' bits it has (also known as the Hamming weight).
	 * 
	 * Example 1:
	 * 
	 * Input: 11 Output: 3 Explanation: Integer 11 has binary representation
	 * 00000000000000000000000000001011
	 */

	public static int hammingWeight(int n) {
		int ones = 0;
		while (n != 0) {
			ones = ones + (n & 1);
			n = n >>> 1;
		}
		return ones;
	}

}
