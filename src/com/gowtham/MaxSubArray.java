package com.gowtham;

public class MaxSubArray {
	
	public static void main(String[] args) {
		int a[] = {3,6,3,-4,1,3,-10, 5,6,0, -2, 1};
		System.out.print("max sub array: " + maxSubArray(a));
	}
	public static int maxSubArray(int[] nums) {

		int[] dp = new int[nums.length];

		dp[0] = nums[0];

		int max = dp[0];

		for (int i = 1; i < nums.length; i++) {

			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);

			max = Math.max(dp[i], max);

		}

		return max;

	}

}
