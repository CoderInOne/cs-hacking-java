package cs.hacking.ds_algo.ds.fundamental.adt;

import org.junit.Test;

public class LinkedListTest {
    private LinkedList<Integer> l = new LinkedList<>();

    @Test
    public void add() {
        l.add(1);
        l.add(2);
        l.add(3);

        l.print();
    }

    @Test
    public void remove() {
        l.add(1);
        l.add(2);
        l.add(1);
//        l.add(2);

        l.remove(1);

        l.add(3);

        l.remove(3);

        l.add(4);

        l.print();
    }
}