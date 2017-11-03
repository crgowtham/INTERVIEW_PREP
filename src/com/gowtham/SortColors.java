package com.gowtham;

public class SortColors {
	// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

	// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

	// Note:
	    // You are not suppose to use the library's sort function for this problem.
	
	public static void main(String[] args) {
		int[] nums = {0,1,2,2,1,1,0,0,2,1};
		
		 int[] res = sortColors(nums);
		 
		 for(int i=0; i< res.length; i++ ) {
			 System.out.println("," + res[i]);
		 }
		 
		 
	}
	
	public static int[] sortColors(int[] nums) {
		int wall =0;
		
		for(int i=0; i < nums.length; i++) {
			if(nums[i]<1) {
				int temp = nums[i];
				nums[i] = nums[wall];
				nums[wall] =  temp;
				
				wall++;
			}
		}
		
		for(int i=0; i < nums.length; i++) {
			if(nums[i]==1) {
				int temp = nums[i];
				nums[i] = nums[wall];
				nums[wall] =  temp;
				
				wall++;
			}
		}
		
		return nums;
	}
}
