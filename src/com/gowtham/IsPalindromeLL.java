package com.gowtham;

import java.util.Stack;

public class IsPalindromeLL {
	
	public static void main(String[] args) {
		LinkedListNode n1 = new LinkedListNode(1);
		
		LinkedListNode n2 = new LinkedListNode(2);
		n1.next = n2;
		LinkedListNode n3 = new LinkedListNode(3);
		n2.next = n3;
		LinkedListNode n4 = new LinkedListNode(2);
		n3.next = n4;
		LinkedListNode n5 = new LinkedListNode(5);
		n4.next = n5;
		n5.next = null;
		
		boolean bool = isPalindrome(n1);
		
	    System.out.println("ispalindromell " + bool);
		
	}
	
	public static class LinkedListNode {
		int data;
		LinkedListNode next;
		
		LinkedListNode(int val) {
			this.data = val;
		}
	}
	
	public static boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head, slow = head;
		
		Stack<Integer> intStack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {
			intStack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) {
			slow = slow.next;
		}
		
		while( slow != null){
			int ele = intStack.pop();
			if(ele != slow.data)
				return false;
			slow = slow.next;
		}
		
		return true;
	}

}
