package com.gowtham;

public class ReverseArrayInPlace {
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4};
		reverse(a);
		
		for(int i=0;i<a.length; i++){
			System.out.println("i: " + a[i] );
		}
	}

	public static void reverse(int[] a) {
		int l = a.length;
		for (int j = 0; j < l / 2; j++) {
			int temp = a[j];
			a[j] = a[l - j - 1];
			a[l - j - 1] = temp;
		}
	}
}