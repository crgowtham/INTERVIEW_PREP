package com.gowtham;

public class BSTFindLeftMostTreeValue {

	/*
	 * Given a binary tree, find the leftmost value in the last row of the tree.
	 * 
	 * Example 1: Input:
	 * 
	 * 2 / \ 1 3
	 * 
	 * Output: 1 Example 2: Input:
	 * 
	 * 1 / \ 2 3 / / \ 4 5 6 / 7
	 * 
	 * Output: 7
	 */

	int ans = 0, h = 0;

	public int findBottomLeftValue(TreeNode root) {
		findBottomLeftValue(root, 1);
		return ans;
	}

	public void findBottomLeftValue(TreeNode root, int depth) {
		if (h < depth) {
			ans = root.val;
			h = depth;
		}
		if (root.left != null)
			findBottomLeftValue(root.left, depth + 1);
		if (root.right != null)
			findBottomLeftValue(root.right, depth + 1);
	}

}
