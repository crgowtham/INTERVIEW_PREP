package com.gowtham;

public class KthSmallestBST {

	/*
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it.
	 * 
	 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
	 * 
	 * Example 1:
	 * 
	 * Input: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \ 2 Output: 1
	 */

	// better keep these two variables in a wrapper class
	private static int number = 0;
	private static int count = 0;

	public int kthSmallest(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		int count = countNodes(root.left);
		if (k <= count) {
			return kthSmallest(root.left, k);
		} else if (k > count + 1) {
			return kthSmallest(root.right, k - 1 - count); // 1 is counted as
															// current node
		}

		return root.val;
	}

	public int countNodes(TreeNode n) {
		if (n == null)
			return 0;

		return 1 + countNodes(n.left) + countNodes(n.right);
	}
}
