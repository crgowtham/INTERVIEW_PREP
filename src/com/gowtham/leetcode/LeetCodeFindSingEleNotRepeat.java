package com.gowtham.leetcode;

public class LeetCodeFindSingEleNotRepeat {
	public int singleNumber(int[] A) {
		int num = 0;
		for (int x : A) {
			num ^= x;
		}
		return num;
	}
}
