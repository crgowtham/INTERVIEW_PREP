package com.gowtham;

public class BSTBalanced {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	boolean balanced = true;

	public boolean isBalanced(TreeNode root) {

		height(root);
		return balanced;

	}

	private int height(TreeNode root) {

		if (root == null)
			return 0;

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		if (Math.abs(leftHeight - rightHeight) > 1) {

			balanced = false;

		}

		return 1 + Math.max(leftHeight, rightHeight);

	}

}
