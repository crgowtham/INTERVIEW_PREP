package com.gowtham;

public class Sqrt {

	public int sqrt(int x) {
		int r = x;
		while (r * r > x) {
			r = ((r + x / r) / 2) | 0;
		}
		return r;
	}

}
