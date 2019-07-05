package cs.hacking.ds_algo.ds.advanced;

import org.junit.Before;
import org.junit.Test;

public class SkipListTest {
    private SkipList skipList;

    @Before
    public void setUp() throws Exception {
        skipList = new SkipList(0.5F);
    }

    @Test
    public void add() {
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);

        System.out.println(skipList);

        System.out.println(skipList.search(1));
        System.out.println(skipList.search(2));
        System.out.println(skipList.search(3));
    }

    @Test
    public void delete() {
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
        skipList.add(4);
        skipList.add(5);

        System.out.println(skipList);

        System.out.println(skipList.search(4));

        skipList.delete(4);

        System.out.println(skipList.search(4));

        System.out.println(skipList);
    }

    @Test
    public void lvl() {
        skipList.setCurLevel(3);
        for (int i = 0; i < 10; i++) {
            System.out.println(skipList.randomLevel());
        }
    }
}