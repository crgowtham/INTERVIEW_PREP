package com.gowtham;

public class BSTNextRightPointer {

	/*
	 * Given the following perfect binary tree,
	 * 
	 * 1 / \ 2 3 / \ / \ 4 5 6 7 After calling your function, the tree should
	 * look like:
	 * 
	 * 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
	 * 
	 */

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode cur = root;
		TreeLinkNode nextLeftmost = null;

		while (cur.left != null) {
			nextLeftmost = cur.left; // save the start of next level
			while (cur != null) {
				cur.left.next = cur.right;
				cur.right.next = cur.next == null ? null : cur.next.left;
				cur = cur.next;
			}
			cur = nextLeftmost; // point to next level
		}
	}

}
