package com.gowtham;

public class PowXY {

	/*
	 * Basic idea is to cut half n each time in while loop, if there is a
	 * remain, multiply it to the final res.
	 */

	public double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N;
		}
		double res = 1;
		while (N > 0) {
			if (N % 2 == 1) {
				res = res * x;
			}
			N = N / 2;
			x = x * x;
		}
		return res;
	}

}
