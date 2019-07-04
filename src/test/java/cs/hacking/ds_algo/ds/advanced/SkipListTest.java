package cs.hacking.ds_algo.ds.advanced;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkipListTest {
    private SkipList skipList;

    @Before
    public void setUp() throws Exception {
        skipList = new SkipList();
    }

    @Test
    public void add() {
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
    }
}