package com.gowtham;

public class LeetCodeBinarySearchInsert {

	// Given a sorted array and a target value, return the index if the target
	// is found. If not,
	// return the index where it would be if it were inserted in order.

	public int searchInsert(int[] A, int target) {
		int L = 0, R = A.length - 1;
		while (L < R) {
			int M = (L + R) / 2;
			if (A[M] < target) {
				L = M + 1;
			} else {
				R = M;
			}
		}
		return (A[L] < target) ? L + 1 : L;
	}

}
