package com.gowtham;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };

		int result = bs(a, 3);
		System.out.println("result: " + result);
	}

	public static int bs(int a[], int x) {
		int l = 0, r = a.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (x == a[m]) {
				return m;
			}

			if (a[m] > x) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}

}
