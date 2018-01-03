package com.gowtham;

public class InorderSucesor {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode InorderSucesor(TreeNode root, TreeNode p) {

		TreeNode successor = null;

		while (root != null) {

			if (p.val < root.val) {

				successor = root;
				root = root.left;

			}

			else {

				root = root.right;

			}

		}

		return successor;

	}
}