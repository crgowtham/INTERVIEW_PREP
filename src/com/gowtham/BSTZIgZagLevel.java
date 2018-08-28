package com.gowtham;

public class BSTZIgZagLevel {

	/*
	 * Given a binary tree, return the zigzag level order traversal of its
	 * nodes' values. (ie, from left to right, then right to left for the next
	 * level and alternate between).
	 * 
	 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15
	 * 7 return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]
	 */

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList();
		travel(res, 0, root);
		return res;
	}

	private void travel(List<List<Integer>> res, int level, TreeNode cur) {
		if (cur == null)
			return;
		if (res.size() <= level) {
			res.add(new ArrayList<Integer>());
		}
		if (level % 2 == 0) {
			res.get(level).add(cur.val);
		} else {
			res.get(level).add(0, cur.val);
		}
		travel(res, level + 1, cur.left);
		travel(res, level + 1, cur.right);
	}

}
