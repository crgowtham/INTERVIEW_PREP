package com.gowtham;

public class RemoveDupArray {
	
	public static void main(String[] args) {
		int nums[] = { 1, 3, 0, 0, 5, 6 };

		int[] res = removeDuplicates(nums);

		for (int t : res) {
			System.out.println("," + t);
		}
	}
	
    public static int[] removeDuplicates(int[] nums) {
        
        if(nums.length == 0 || nums == null) return null;
        if(nums.length < 2) return null;
        
        int index = 1;
        
        for(int i = 1; i < nums.length; i++) {
            
            if(nums[i] != nums[i - 1]) {
                
                nums[index++] = nums[i];
                
            }
            
        }
        
        return nums;
        
    }

}
