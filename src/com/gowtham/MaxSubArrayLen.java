package com.gowtham;

import java.util.HashMap;

public class MaxSubArrayLen {
	
	public static void main(String [] args) {
		int a[] = {1, -1, 5, -2, 3};
		
		System.out.println("maxsubarraylen: " + maxSubArrayLen(a, 3));
	}

	public static int maxSubArrayLen(int[] nums, int k) {

		if (nums.length == 0)
			return 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int maxLength = 0;

		int total = 0;

		map.put(0, -1);

		for (int i = 0; i < nums.length; i++) {

			total += nums[i];
			if (map.containsKey(total - k))
				maxLength = Math.max(maxLength, i - map.get(total - k));
			if (!map.containsKey(total))
				map.put(total, i);

		}

		return maxLength;

	}

}
