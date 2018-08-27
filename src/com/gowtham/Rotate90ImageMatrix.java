package com.gowtham;

public class Rotate90ImageMatrix {

	/*
	 * You are given an n x n 2D matrix representing an image.
	 * 
	 * Rotate the image by 90 degrees (clockwise).
	 * 
	 * Note:
	 * 
	 * You have to rotate the image in-place, which means you have to modify the
	 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
	 * rotation.
	 * 
	 * Example 1:
	 * 
	 * Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
	 * 
	 * rotate the input matrix in-place such that it becomes: [ [7,4,1],
	 * [8,5,2], [9,6,3] ]
	 */

	/*
	 * clockwise rotate first reverse up to down, then swap the symmetry 1 2 3 7
	 * 8 9 7 4 1 4 5 6 => 4 5 6 => 8 5 2 7 8 9 1 2 3 9 6 3
	 */

	public void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
		int temp = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = temp;
	}

	public void rotate(int[][] matrix) {
		// reverse columns
		for (int k = 0; k < matrix[0].length; k++) {
			for (int i = 0, j = matrix.length - 1; i <= j; i++, j--) {
				swap(matrix, i, k, j, k);
			}
		}

		// reverse diagonally
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[0].length; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

}
