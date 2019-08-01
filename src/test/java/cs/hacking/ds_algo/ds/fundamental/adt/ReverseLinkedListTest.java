package cs.hacking.ds_algo.ds.fundamental.adt;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void reverseList() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);
        head.next.next.next = new ReverseLinkedList.ListNode(3);

        ReverseLinkedList r = new ReverseLinkedList();
        ReverseLinkedList.ListNode newh = r.reverseList(head);
        while (newh != null) {
            System.out.println(newh.val);
            newh = newh.next;
        }
    }
}