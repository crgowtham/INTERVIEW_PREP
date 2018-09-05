package com.gowtham;

public class IntersectionOfTwoArrs {

	/*
	 * Given two arrays, write a function to compute their intersection.
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2]
	 */

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return new int[0];
		}

		final List<Integer> result = new ArrayList<>();
		final Set<Integer> set = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}

		for (int num : nums2) {
			if (set.contains(num)) {
				result.add(num);
				set.remove(num);
			}
		}

		return result.stream().mapToInt(number -> number).toArray();
	}
}
