package com.gowtham;

public class BTUpsideDown {

	public TreeNode UpsideDownBinaryTree(TreeNode root) {
		return dfsBottomUp(root, null);
	}

	private TreeNode dfsBottomUp(TreeNode p, TreeNode parent) {
		if (p == null)
			return parent;
		TreeNode root = dfsBottomUp(p.left, p);
		p.left = (parent == null) ? parent : parent.right;
		p.right = parent;
		return root;
	}

}
