package com.gowtham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

//Example:

//nums = [1, 2, 3]
//target = 4

//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)

//Note that different sequences are counted as different combinations.

//Therefore the output is 7.

//Follow up:
// What if negative numbers are allowed in the given array?
// How does it change the problem?
// What limitation we need to add to the question to allow negative numbers?

public class CombinationSum {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int target = 4;
		System.out.println("CSum: " + combinationSum4(nums, target));
	}

	public static int combinationSum4(int[] nums, int target) {

		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {

				if (i - nums[j] >= 0) {

					dp[i] += dp[i - nums[j]];

				}

			}

		}

		return dp[target];

	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		findCombination(candidates, 0, target, result, arr);
		return result;
	}

	public void findCombination(int[] candidates, int index, int target, List<List<Integer>> result,
			List<Integer> arr) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			result.add(arr);
			return;
		}
		while (index < candidates.length) {
			List<Integer> newArr = new ArrayList<Integer>(arr);
			newArr.add(candidates[index]);
			findCombination(candidates, index, target - candidates[index], result, newArr);
			index++;
		}

	}

}