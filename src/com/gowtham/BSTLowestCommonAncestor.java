package com.gowtham;


public class BSTLowestCommonAncestor {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(4);
    	root.left.left = new TreeNode(1);
    	root.right.right = new TreeNode(5);
    	
    	System.out.println("SumLeft: " + lowestCommonAncestor(root, root.left.left, root.right.right).val);
    	
    }

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || root == p || root == q)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;

		return left == null ? right : left;

	}

}
