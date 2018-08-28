package com.gowtham;

public class BSTRecover {

	/*
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * 
	 * Recover the tree without changing its structure.
	 * 
	 * Example 1:
	 * 
	 * Input: [1,3,null,null,2]
	 * 
	 * 1 / 3 \ 2
	 * 
	 * Output: [3,1,null,null,2]
	 * 
	 * 3 / 1 \ 2
	 */

	public void recoverTree(TreeNode root) {
		// use inorder traversal to detect incorrect node

		inOrder(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	TreeNode prev = null;
	TreeNode first = null;
	TreeNode second = null;

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		// search left tree
		inOrder(root.left);

		// in inorder traversal of BST, prev should always have smaller value
		// than current value
		if (prev != null && prev.val >= root.val) {
			// incorrect smaller node is always found as prev node
			if (first == null)
				first = prev;
			// incorrect larger node is always found as curr(root) node
			second = root;
		}

		// update prev node
		prev = root;

		// search right tree
		inOrder(root.right);
	}
}
