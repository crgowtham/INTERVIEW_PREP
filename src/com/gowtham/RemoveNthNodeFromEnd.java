package com.gowtham;

public class RemoveNthNodeFromEnd {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n1.next = n2;
		ListNode n3 = new ListNode(3);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;
		n5.next = null;
		
		ListNode resNode = removeNthFromEnd(n1, 1);
		
	    while(resNode != null) {
	    	System.out.println("--> " + resNode.data);
	    	resNode = resNode.next;
	    }
	}

	public static class ListNode {
		int data;
		ListNode next;
		
		ListNode(int x) {
			this.data = x;
		}
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head, fast=head, start = head;
		
		for(int i=1; i<=n+1; i++) {
			fast = fast.next;
		}
		
		while(fast != null) {
			slow = slow.next;
			fast= fast.next;
		}
		
		slow.next = slow.next.next;
		return start;
		
	}
}
