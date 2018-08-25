package com.gowtham;

public class SudokuSolver {

	/*
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
	 * 
	 * A sudoku solution must satisfy all of the following rules:
	 * 
	 * Each of the digits 1-9 must occur exactly once in each row. Each of the
	 * digits 1-9 must occur exactly once in each column. Each of the the digits
	 * 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
	 */

	boolean backtrack(char[][] board, int index) {
		if (index == 81)
			return true;

		int r = index / 9, c = index % 9;
		if (board[r][c] != '.') {
			return backtrack(board, index + 1);
		} else {
			for (char ch = '1'; ch <= '9'; ch++) {
				if (valid(board, r, c, ch)) {
					board[r][c] = ch;
					if (backtrack(board, index + 1))
						return true;
					board[r][c] = '.';
				}
			}
		}

		return false;
	}

	boolean valid(char[][] board, int row, int col, char ch) {
		for (int c = 0; c < 9; c++)
			if (board[row][c] == ch)
				return false;
		for (int r = 0; r < 9; r++)
			if (board[r][col] == ch)
				return false;

		int rI = (row / 3) * 3, cI = (col / 3) * 3;
		for (int r = rI; r < rI + 3; r++) {
			for (int c = cI; c < cI + 3; c++) {
				if (board[r][c] == ch)
					return false;
			}
		}

		return true;
	}

}
