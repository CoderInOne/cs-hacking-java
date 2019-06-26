package cs.hacking.ds_algo.leetcode.day00;

/**
 * bad code -> LinkedListCycleII00
 * In LinkedListCycleII00, there're multiple check null, but think of this:
 * when node is null? no cycle! and note that f is faster than s, so f will meet
 * null(last node) first. so we only check whether f and f.next is null
 */
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode s = head;
		ListNode f = head;

		// detect cycle
		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;

			// cycle detected and find start node of cycle
			if (s == f) {
				while (head != f) {
					head = head.next;
					f = f.next;
				}

				return head;
			}
		}

		return null;
	}

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
