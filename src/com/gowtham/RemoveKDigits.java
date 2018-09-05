package com.gowtham;

public class RemoveKDigits {

	/*
	 * Given a non-negative integer num represented as a string, remove k digits
	 * from the number so that the new number is the smallest possible.
	 * 
	 * Note: The length of num is less than 10002 and will be ≥ k. The given num
	 * does not contain any leading zero. Example 1:
	 * 
	 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the
	 * three digits 4, 3, and 2 to form the new number 1219 which is the
	 * smallest.
	 */

	String removeKdigits(String num, int k) {
		while (k > 0) {
			int n = num.size();
			int i = 0;
			while (i + 1 < n && num[i] <= num[i + 1])
				i++;
			num.erase(i, 1);
			k--;
		}
		// trim leading zeros
		int s = 0;
		while (s < (int) num.size() - 1 && num[s] == '0')
			s++;
		num.erase(0, s);

		return num == "" ? "0" : num;
	}

}
