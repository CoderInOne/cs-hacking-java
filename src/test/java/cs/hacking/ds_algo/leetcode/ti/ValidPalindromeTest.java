package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    @Test
    public void solve() {
        ValidPalindrome vp = new ValidPalindrome();
        String in = "OP";
        assertFalse(vp.solve(in));
    }
}