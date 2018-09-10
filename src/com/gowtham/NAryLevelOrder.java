package com.gowtham;

public class NAryLevelOrder {

	/*
	 * Given an n-ary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 * 
	 * For example, given a 3-ary tree:
	 * 
	 * 
	 * 
	 * 
	 * 
	 * We should return its level order traversal:
	 * 
	 * 
	 * 
	 * 
	 * 
	 * [ [1], [3,2,4], [5,6] ]
	 */

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> ret = new LinkedList<>();

		if (root == null)
			return ret;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> curLevel = new LinkedList<>();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Node curr = queue.poll();
				curLevel.add(curr.val);
				for (Node c : curr.children)
					queue.offer(c);
			}
			ret.add(curLevel);
		}

		return ret;
	}
}
