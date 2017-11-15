package com.gowtham;

import java.util.HashMap;
import java.util.Map;

public class LongestConEle {

	public static void main(String[] args) {
		int a[] = { 1, 4, 3, 7, 9, 0, 2 };
		System.out.println("longest con : " + longestConsecutive(a));
	}

	public static int longestConsecutive(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int n : nums) {
			if (!map.containsKey(n)) {
				int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
				int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;

				int sum = left + right + 1;
				map.put(n, sum);
				res = Math.max(res, sum);

				map.put(n - left, sum);
				map.put(n + right, sum);

			} else {
				continue;
			}
		}

		return res;
	}
}
