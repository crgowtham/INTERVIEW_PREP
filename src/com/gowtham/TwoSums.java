package com.gowtham;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
	
	public static void main(String[] args) {
		
		int a[] = { 1,2,35, 4, 54, 61, 7};
		
		int[] result = twoSum(a, 65);
		
		System.out.println("result: " + result[0] + " : " + result[1] );
		
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int a[] = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< numbers.length; i++) {
			if(map.containsKey(target - numbers[i])) {
				a[1] = i + 1;
				a[0] = map.get((target - numbers[i]));
				return a;
			}
			map.put(numbers[i], i+1);
		}
		
		return a;
	}

}
