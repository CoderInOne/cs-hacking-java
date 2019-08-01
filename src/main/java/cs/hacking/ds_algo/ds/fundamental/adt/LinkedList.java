package cs.hacking.ds_algo.ds.fundamental.adt;

public class LinkedList<T> {
    class Node<U> {
        U data;
        Node<U> next;

        Node(U data) {
            this.data = data;
        }
    }

    private Node head = new Node<>(null);
    private Node tail = head;

    void add(T t) {
        tail.next = new Node<>(t);
        tail = tail.next;
    }

    void remove(T t) {
        Node<T> pre = head;
        while (pre.next != null) {
            if (pre.next.data == t) {
                pre.next = pre.next.next;
            }
            else {
                pre = pre.next;
            }
        }

        tail = pre;
    }

    void print() {
        Node<T> n = head;
        while (n.next != null) {
            System.out.println(n.next.data);
            n = n.next;
        }
    }
}
