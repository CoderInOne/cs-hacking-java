package cs.hacking.ds_algo.leetcode.day00;

public class LinkedListCycleII00 {
	public ListNode detectCycle(ListNode head) {
		ListNode s = head;
		ListNode f = head;

		// detect cycle
		while (s != null) {
			s = s.next;

			if (f.next == null || s == null) {
				return null;
			}

			f = f.next.next;

			if (f == null) {
				return null;
			}

			// bad code cause infinite loop
			// exceptional case: multiple node have same value
			// if (s.val == f.val) {
			if (s == f) {
				break;
			}
		}


		if (s == null) {
			return null;
		}

		// find start index of cycle
		s = head;
		while (s != f) {
			s = s.next;
			f = f.next;
		}

		return s;
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
