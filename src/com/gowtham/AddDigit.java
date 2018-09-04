package com.gowtham;

public class AddDigit {

	/*
	 * Given a non-negative integer num, repeatedly add all its digits until the
	 * result has only one digit.
	 * 
	 * Example:
	 * 
	 * Input: 38 Output: 2 Explanation: The process is like: 3 + 8 = 11, 1 + 1 =
	 * 2. Since 2 has only one digit, return it.
	 */

	public int addDigits(int num) {
		if (num == 0) {
			return 0;
		}
		if (num % 9 == 0) {
			return 9;
		} else {
			return num % 9;
		}
	}

}
