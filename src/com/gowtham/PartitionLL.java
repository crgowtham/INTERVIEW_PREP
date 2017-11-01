package com.gowtham;

import com.gowtham.RemoveDuplicatedLL.ListNode;

public class PartitionLL {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(4);
		n1.next = n2;
		ListNode n3 = new ListNode(4);
		n2.next = n3;
		ListNode n4 = new ListNode(4);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;
		n5.next = null;
		
		ListNode resNode = deleteDups(n1);
		
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

}
