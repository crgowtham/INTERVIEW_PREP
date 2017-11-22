package com.gowtham;

public class LLReverse {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseList(ListNode head) {

		if (head == null)
			return head;

		ListNode newHead = null;

		while (head != null) {

			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;

		}

		return newHead;

	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		
		ListNode result = reverseList(head);
		
		while(result != null) {
			System.out.println(result.val + ":");
			result = result.next;
		}
	}

}
