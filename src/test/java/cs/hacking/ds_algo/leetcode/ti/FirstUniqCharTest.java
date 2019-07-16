package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqCharTest {

    @Test
    public void solve() {
        FirstUniqChar fuc = new FirstUniqChar();
        String in = "leetcode";
        assertEquals(0, fuc.solve(in));

        in = "eeh";
        assertEquals(2, fuc.solve(in));

        in = "";
        assertEquals(-1, fuc.solve(in));

        in = "eeff";
        assertEquals(-1, fuc.solve(in));
    }
}