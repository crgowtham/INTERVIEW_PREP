package com.gowtham;

public class MergeKSortedLL {
	public ListNode mergeKLists(ListNode[] lists) {
		int n = lists.length;
		if (n == 0)
			return null;
		for (int sz = 1; sz < n; sz <<= 1)
			for (int low = 0; low < n - sz; low += sz << 1)
				lists[low] = mergeTwoLists(lists[low], lists[low + sz]);
		return lists[0];
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
