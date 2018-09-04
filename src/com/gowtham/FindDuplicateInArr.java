package com.gowtham;

public class FindDuplicateInArr {

	/*
	 * The idea is calculate a middle number between low and high, then in for
	 * loop to check total numbers less or equal than middle. If numbers less
	 * than middle, then the duplicate must fall in the [low, middle] range;
	 * else in [middle+1, high]. For this solution, time is O(nlgn) and space is
	 * O(1) for my understanding.
	 * 
	 * Except declare "int count = 0;" out side of while loop. You can also
	 * consider the following two suggestions:
	 * 
	 * Check nums == null before nums.length == 0, else you can get a
	 * NullPointException as well. You can also add data validation code below
	 * in the for loop to make it more robust. if(x >= nums.length || x < 1)
	 * return x; Here is my practice after I learnt your idea and thanks again
	 * for your sharing:
	 * 
	 * 
	 */

	public static int findDuplicate(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int low = 1, high = nums.length - 1, mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			int count = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= mid)
					count++;
			}
			if (count > mid)
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

}
