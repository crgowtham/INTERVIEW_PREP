package com.gowtham;

public class LLReverseInGrps {

	public ListNode reverseKGroup(ListNode head, int k) {
		int cnt = 0;
		for (ListNode curr = head; curr != null; curr = curr.next)
			++cnt;
		return reverseKGroup(head, k, cnt);
	}

	public ListNode reverseKGroup(ListNode head, int k, int cnt) {
		if (cnt < k)
			return head;
		ListNode curr = head, tmp = null, ans = null;
		for (int i = 0; i < k; ++i) {
			tmp = curr;
			curr = curr.next;
			tmp.next = ans;
			ans = tmp;
		}
		head.next = reverseKGroup(curr, k, cnt - k);
		return ans;
	}

	public Node reveseGrps(Node head, int k) {
		int x = k;
		Node head_next = null;
		Node h = head;
		Node head_prev = null;
		while (h != null && x > 0) {
			head_next = h.next;
			h.next = head_prev;
			head_prev = h;
			h = head_next;
			x--;
		}
		if (head_next != null) {
			head.next = reveseGrps(head_next, k);
		}
		return head_prev;

	}

	public void display(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print("->" + n.data);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		ReverseInGrps r = new ReverseInGrps();
		Node x = r.reveseGrps(head, 3);
		r.display(x);

	}

}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}