package com.gowtham;

public class RemoveDuplicatesInArray {


	public int removeDuplicates(int[] nums) {
		int length = 0;
		for (int i = 0; i < nums.length; i++) {

			if (i - 1 >= 0 && nums[i] != nums[i - 1]) {
				length++;
				nums[length] = nums[i];
			}
		}
		return length + 1;
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int num : nums)
			nums[i++] = (num != val) ? num : i--;
		return i;
	}
}
