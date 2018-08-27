package com.gowtham;

public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < Math.pow(2, n); i++)
			result.add(i ^ i / 2);
		return result;
	}

	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < 1 << n; i++)
			result.add(i ^ i >> 1);
		return result;
	}

}
