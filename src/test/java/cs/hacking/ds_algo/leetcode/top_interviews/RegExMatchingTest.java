package cs.hacking.ds_algo.leetcode.top_interviews;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RegExMatchingTest {

    @Test
    public void match() {
        RegExMatching matcher = new RegExMatching();
        assertTrue(matcher.match("aa", "a*"));
        assertTrue(matcher.match("ab", "a."));
        assertTrue(matcher.match("aaa", "aaa*"));
        assertTrue(matcher.match("ab", ".*"));
        assertTrue(matcher.match("aba", ".*"));
        assertTrue(matcher.match("aab", "c*a*b"));

        assertFalse(matcher.match("aa", "a"));
        assertFalse(matcher.match("mississippi", "mis*is*ip*"));
    }
}