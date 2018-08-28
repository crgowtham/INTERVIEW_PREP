package com.gowtham;

public class RotateLL {

	/*
	 * Given a linked list, rotate the list to the right by k places, where k is
	 * non-negative.
	 * 
	 * Example 1:
	 * 
	 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL
	 * Explanation: rotate 1 steps to the right: 5->1->2->3->4->NULL rotate 2
	 * steps to the right: 4->5->1->2->3->NULL
	 */

	/*
	 * My solution has O(n) time complexity and O(1) memory. The basic idea is
	 * to connect the list into a circle. First, count the length of list while
	 * going through the list to find the end of it. Connect the tail to head.
	 * The problem asked to rotate k nodes, however, now the tail is at the end
	 * of the list and its difficult to move backward, so move (k - len) nodes
	 * along the list instead. "k = k % len" saves the unnecessary moves because
	 * rotate a list with length = len by len times doesn't change the list at
	 * all.
	 */

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode cur = head, prev = null;
		int length = 0;
		while (cur != null) {
			prev = cur;
			cur = cur.next;
			++length;
		}
		prev.next = head;
		k %= length;
		int left = (length - k);
		cur = head;
		while (left > 0) {
			prev = cur;
			cur = cur.next;
			--left;
		}
		prev.next = null;
		return cur;
	}
}
