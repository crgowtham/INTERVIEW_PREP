package com.gowtham;

public class LargestRectangleInHistogram {

	/*
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3]. Input: [2,1,5,6,2,3] Output: 10
	 */

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		return getMax(heights, 0, heights.length);
	}

	int getMax(int[] heights, int s, int e) {
		if (s + 1 >= e)
			return heights[s];
		int min = s;
		boolean sorted = true;
		for (int i = s; i < e; i++) {
			if (i > s && heights[i] < heights[i - 1])
				sorted = false;
			if (heights[min] > heights[i])
				min = i;
		}
		if (sorted) {
			int max = 0;
			for (int i = s; i < e; i++) {
				max = Math.max(max, heights[i] * (e - i));
			}
			return max;
		}
		int left = (min > s) ? getMax(heights, s, min) : 0;
		int right = (min < e - 1) ? getMax(heights, min + 1, e) : 0;
		return Math.max(Math.max(left, right), (e - s) * heights[min]);
	}

}
