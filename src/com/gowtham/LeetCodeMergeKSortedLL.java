package com.gowtham;

public class LeetCodeMergeKSortedLL {

	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty())
			return null;
		Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator);
		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);
			}
		}
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			p = p.next;
			if (node.next != null) {
				queue.add(node.next);
			}
		}
		return dummyHead.next;
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty())
			return null;
		int end = lists.size() - 1;
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin, merge2Lists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		return lists.get(0);
	}

	private ListNode merge2Lists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;
		return dummyHead.next;
	}

}
