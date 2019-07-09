package cs.hacking.ds_algo.leetcode.top_interviews;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching
 * with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 */
public class WildMatching {
    // Recursive solution, FAIL when size of input is large
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '*' || p.charAt(0) == '?');
        if (p.charAt(0) == '*') {
            if (p.length() == 1) {
                return true;
            }
            char nextp = p.charAt(1);
            if (nextp == '*') {
                return isMatch(s, p.substring(1));
            }

            if (s.isEmpty()) {
                return false;
            }

            int i = nextp == '?' ? 0 : s.indexOf(nextp);
            if (i < 0) {
                return false;
            }
            return isMatch(s.substring(i + 1), p.substring(2)) || isMatch(s.substring(i + 1), p);
        }
        else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    /**
     * aaaa *a
     *
     */
    public boolean isMatchDP(String s, String p) {
        return false;
    }
}
