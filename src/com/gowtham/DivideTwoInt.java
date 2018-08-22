package com.gowtham;

public class DivideTwoInt {
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		int flag = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			flag = -1;
		if (divisor > 0)
			divisor = -divisor;
		if (dividend > 0)
			dividend = -dividend;
		int result = 0;
		while (dividend <= divisor) {
			int count = 1, tempDivisor = divisor;
			while (dividend - tempDivisor <= tempDivisor) {
				count <<= 1;
				tempDivisor <<= 1;
			}
			result += count;
			dividend -= tempDivisor;
		}
		return flag * result;
	}

}
