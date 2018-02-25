package com.gowtham.leetcode;

public class LeetCodeIsValidBST {

	public boolean isValidBST(TreeNode root) {
		return valid(root, null, null);
	}

	private boolean valid(TreeNode p, Integer low, Integer high) {
		if (p == null)
			return true;
		return (low == null || p.val > low) && (high == null || p.val < high) && valid(p.left, low, p.val)
				&& valid(p.right, p.val, high);
	}

	// other solution

	private TreeNode prev;

	public boolean isValidBST(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}

	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null)
			return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val)
				return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}

}
