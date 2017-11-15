package com.gowtham;

public class BuySellStock {

	public static void main(String[] args) {

		int a[] = { 3, 2, 5, 1, 5, 2, 4, 1, 7 };
		int max = maxProfit(a);
		System.out.println("-->" + max);

	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;

		int max = 0;

		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > min) {
				max = Math.max(max, prices[i] - min);
			} else {
				min = prices[i];
			}
		}
		return max;
	}
}
