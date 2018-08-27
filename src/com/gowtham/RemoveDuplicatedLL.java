package com.gowtham;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatedLL {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode list = head;

		while (list != null) {
			if (list.next == null) {
				break;
			}
			if (list.val == list.next.val) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}

		return head;
	}

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

		while (resNode != null) {
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

	public static ListNode deleteDups(ListNode n) {
		Set<Integer> intSet = new HashSet<Integer>();
		ListNode head = n;
		ListNode prev = null;

		while (n != null) {
			if (intSet.contains(n.data)) {
				prev.next = n.next;
			} else {
				intSet.add(n.data);
				prev = n;
			}
			n = n.next;
		}
		return head;
	}

}
