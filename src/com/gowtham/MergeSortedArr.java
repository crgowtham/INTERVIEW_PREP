package com.gowtham;

public class MergeSortedArr {
	
	public static void main(String args[]){
		int[] a = new int[6];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		int b[] = {5,6};
		mergeArray(a, 4, b, b.length);
		
		for(int i=0; i<a.length; i++) {
			System.out.print("Values :" + a[i]);
		}
	}
	
	public static void mergeArray(int a[], int m, int b[], int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		
		while(i > -1 && j > -1){
			if(a[i] > b[j]) {
				System.out.println("k: " + k + "i: " + i);
				a[k--] = a[i--];
			} else {
				System.out.println("k: " + k + "j: " + j);
				a[k--] = b[j--];
			}
		}
		
		while (j > -1) {
			a[k--] = b[j--];
		}
	}

}
