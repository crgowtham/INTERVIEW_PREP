package com.gowtham;

public class InvertBinaryTree {

	/*
	 * Invert a binary tree.
	 * 
	 * Example:
	 * 
	 * Input:
	 * 
	 * 4 / \ 2 7 / \ / \ 1 3 6 9 Output:
	 * 
	 * 4 / \ 7 2 / \ / \ 9 6 3 1
	 */

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		final TreeNode left = root.left, right = root.right;
		root.left = invertTree(right);
		root.right = invertTree(left);
		return root;
	}

	public TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		final Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			final TreeNode node = stack.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
		return root;
	}

}
