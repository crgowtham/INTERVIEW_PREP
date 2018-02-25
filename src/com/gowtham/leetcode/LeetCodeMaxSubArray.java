package com.gowtham.leetcode;

public class LeetCodeMaxSubArray {

	public int maxSubArray(int[] A) {
		int maxEndingHere = A[0], maxSoFar = A[0];
		for (int i = 1; i < A.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}

}
