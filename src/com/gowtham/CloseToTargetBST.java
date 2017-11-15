package com.gowtham;

public class CloseToTargetBST {
	
	class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;
		
	}

	public int closestValue(TreeNode root, double target) {

		int value = root.val;
		TreeNode child = root.val < target ? root.right : root.left;

		if (child == null)
			return value;

		int childValue = closestValue(child, target);

		return Math.abs(value - target) < Math.abs(childValue - target) ? value : childValue;

	}

}
