package com.gowtham;

public class SwapPairLL {

	public ListNode swapPairs(ListNode head) {
		// base case
		if (head == null || head.next == null) {
			// size = 0 , size = 1
			return head;
		}

		// recursion
		ListNode node1 = head.next;
		ListNode next = node1.next;
		node1.next = head;
		head.next = swapPairs(next);
		return node1;
	}

	public ListNode swapPairs(ListNode head) {
		if (head != null && head.next != null) {
			ListNode n = head.next;
			head.next = swapPairs(head.next.next);
			n.next = head;
			return n;
		}
		return head;
	}

	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}

}
