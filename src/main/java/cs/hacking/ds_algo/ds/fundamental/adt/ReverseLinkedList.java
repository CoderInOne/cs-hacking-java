package cs.hacking.ds_algo.ds.fundamental.adt;

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newNext = null;
        while (head != null) {
            ListNode n = head.next;
            head.next = newNext;
            newNext = head;
            head = n;
        }
        return newNext;
    }
}
