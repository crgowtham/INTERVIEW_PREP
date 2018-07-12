package com.gowtham;

public class MatrixDiagonals {

	public static void print(int[][] a) {

		// print first half
		int row = 0;
		int col;

		while (row < a.length) {
			col = 0;
			int rowTemp = row;
			while (rowTemp >= 0) {
				System.out.print(a[rowTemp][col] + " ");
				rowTemp--;
				col++;
			}
			System.out.println();
			row++;
		}

		// print second half
		col = 1;

		while (col < a.length) {
			int colTemp = col;
			row = a.length - 1;
			while (colTemp <= a.length - 1) {
				System.out.print(a[row][colTemp] + " ");
				row--;
				colTemp++;
			}
			System.out.println();
			col++;
		}

	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		print(a);

	}
}