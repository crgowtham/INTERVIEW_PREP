package com.gowtham;

public class MaxSubProduct {

	/*
	 * Given an integer array nums, find the contiguous subarray within an array
	 * (containing at least one number) which has the largest product.
	 * 
	 * Example 1:
	 * 
	 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
	 */

	public int maxProduct(int[] A) {
		assert A.length > 0;
		int max = A[0], min = A[0], maxAns = A[0];
		for (int i = 1; i < A.length; i++) {
			int mx = max, mn = min;
			max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
			min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
			maxAns = Math.max(max, maxAns);
		}
		return maxAns;
	}

}
