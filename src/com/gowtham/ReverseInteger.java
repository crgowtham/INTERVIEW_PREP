package com.gowtham;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = 23432523;
		System.out.println("Result: " + reverse(x));
	}
	
	public static int reverse(int x) {
		int result = 0;
		
		while(x != 0) {
			int tail = x % 10;
			int newresult = result * 10 + tail;
			if((newresult - tail) / 10 != result) {
				return 0;
			}
			result = newresult;
			x = x/10;
		}
		
		return result;
	}
	
	public int reverse1(int x) {
		int ret = 0;
		while (x != 0) {
			ret = ret * 10 + x % 10;
			x /= 10;
		}
		return ret;
	}
}
