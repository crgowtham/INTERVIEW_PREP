package com.gowtham;

import java.util.Stack;

public class LLPalindrome {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	};

	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) return true;
		
		Stack<Integer> llstack = new Stack<Integer>();
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			llstack.push(slow.val);
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while(slow != null) {
			if(llstack.pop() != slow.val) return false;
			slow = slow.next;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		
		System.out.println("ISPALAINDROME: " + isPalindrome(head));
	}
}
