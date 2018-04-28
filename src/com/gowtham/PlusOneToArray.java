package com.gowtham;

public class PlusOneToArray {
	
	public static void main(String[] args) {
		
		int a[]={9,9,9,9};
		int b[] = addOne(a);
		for(int i=0; i<b.length; i++) {
			System.out.println(b[i]);
		}
	}

	public static final int[] addOne(int[] digits) {
		int carry = 1;
		int[] result = new int[digits.length];
		for (int i = digits.length - 1; i >= 0; i--) {
			int val = digits[i] + carry;
			result[i] = val % 10;
			carry = val / 10;
		}
		if (carry == 1) {
			result = new int[digits.length + 1];
			result[0] = 1;
		}
		return result;
	}

}
