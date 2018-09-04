package com.gowtham;

/* Dynamic Programming Java implementation of LIS problem */
/*
 * Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20
 */
class LongestIncreasingSubSeq {
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;

		for (int x : nums) {
			int i = Arrays.binarySearch(dp, 0, len, x);
			if (i < 0)
				i = -(i + 1);
			dp[i] = x;
			if (i == len)
				len++;
		}

		return len;
	}

	public static void main(String args[]) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "n");
	}
}