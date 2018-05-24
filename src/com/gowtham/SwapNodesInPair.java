package com.gowtham;

public class SwapNodesInPair {
	public static Node swapNodeIterative(Node head) {
		Node ptrOne_prev = null;
		Node baseHead = null;
		while (head != null && head.next != null) {
			// Take 2 pointers, one on head
			Node ptrOne = head;
			// another on head.next
			Node ptrTwo = head.next;
			// store the reference of next node of pointer 2.
			Node ptrTwoNext = ptrTwo.next;
			// make the pointer 1 points to pointer2 next.
			ptrOne.next = ptrTwoNext;

			if (ptrOne_prev != null) {
				// link the next pair swap to the previous one
				ptrOne_prev.next = ptrTwo;
			} else {
				// pointer 2 will become the new head after the first swap.
				baseHead = ptrTwo;
			}
			// reverse the next link of pointer 1.
			ptrTwo.next = head;
			// move 2 modes forward for next pairwise swap.
			ptrOne_prev = ptrOne;
			head = ptrTwoNext;
		}
		return baseHead;
	}

	public static Node swapNodeRecursive(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// change the link for first 2 nodes and
		// make a recursive call to rest of the list.
		Node ptrOne = head;
		Node ptrTwo = head.next;
		Node ptrTwoNext = ptrTwo.next;
		ptrTwo.next = head;
		Node newhead = ptrTwo;
		ptrOne.next = swapNodeRecursive(ptrTwoNext);
		return newhead;
	}

	public static void display(Node head) {
		// System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);

		Node x = swapNodeIterative(head);
		System.out.println("\n Swapping Nodes using Iterative method");
		display(x);
		System.out.println("\n Swapping again using Recursive method");
		Node n = swapNodeRecursive(x);
		display(n);
	}

	class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
