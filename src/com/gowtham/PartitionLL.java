package com.gowtham;

public class PartitionLL {
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		ListNode n3 = new ListNode(7);
		n2.next = n3;
		ListNode n4 = new ListNode(2);
		n3.next = n4;
		ListNode n5 = new ListNode(5);
		n4.next = n5;
		n5.next = null;
		
		ListNode resNode = partition(n1, 3);
		
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
	
	public static ListNode partition(ListNode node, int x) {
		ListNode head = node, tail = node;
		while(node != null) {
			ListNode next = node.next;
			if(node.data < x) {
				node.next =head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

}
