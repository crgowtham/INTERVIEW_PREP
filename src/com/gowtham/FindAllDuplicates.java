package com.gowtham;

public class FindAllDuplicates {

	// when find a number i, flip the number at position i-1 to negative.
	// if the number at position i-1 is already negative, i is the number that
	// occurs twice.

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> newList = new ArrayList<Integer>(); // creating a new List
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]); // Taking the absolute value to find
											// index
			if (nums[index - 1] > 0) {
				nums[index - 1] = -nums[index - 1];
			} else {
				// If it is not greater than 0 (i.e) negative then the number is
				// a duplicate
				newList.add(Math.abs(nums[i]));
			}
		}
		return newList;
	}

}
