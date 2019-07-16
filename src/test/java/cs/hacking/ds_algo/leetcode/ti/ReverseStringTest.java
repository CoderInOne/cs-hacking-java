package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void solve() {
        ReverseString rs = new ReverseString();
        char[] s = new char[]{'a', 'b'};
        rs.solve(s);
        assertArrayEquals(new char[]{'b', 'a'}, s);

        s = new char[]{'a'};
        rs.solve(s);
        assertArrayEquals(new char[]{'a'}, s);

        s = new char[]{'a', 'b', 'c'};
        rs.solve(s);
        assertArrayEquals(new char[]{'c', 'b', 'a'}, s);
    }
}