package com.gowtham;

public class MoveZero {

	public static void main(String[] args) {
		int nums[] = { 1, 3, 0, 4, 0, 5, 6 };

		int[] res = moveZeroes(nums);

		for (int t : res) {
			System.out.println("," + t);
		}

	}

	public static int[] moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		int index = 0;
		for (int num : nums) {

			if (num != 0) {
				nums[index] = num;
				index++;
			}
		}

		while (index < nums.length) {
			nums[index] = 0;
			index++;
		}

		return nums;
	}

}
