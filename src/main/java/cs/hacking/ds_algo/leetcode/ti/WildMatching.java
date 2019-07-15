package cs.hacking.ds_algo.leetcode.ti;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching
 * with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * TODO what's time complexity for these three solution?
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
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public boolean isMatchDPTopDown(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        return matchDPTopDown(s, s.length() - 1, p, p.length() - 1, dp);
    }

    private boolean matchDPTopDown(String s, int n, String p, int m, boolean[][] dp) {
        // pre-process: what if n or m < 0, NOTE match from end to start
        // 1. m && n: return true
        // 2. ONLY m: return false
        // 3. ONLY n: return p.startAs('****')
        if (n < 0 && m < 0) {
            return true;
        }
        else if (m < 0) {
            return false;
        }
        else if (n < 0) {
            while (m >= 0) {
                if (p.charAt(m) != '*') {
                    return false;
                }
                m--;
            }
            return true;
        }

        // do match and compute DP
        if (!dp[n][m]) {
            if (p.charAt(m) == '*') {
                // skip continuous *
                while (m - 1 >= 0 && p.charAt(m - 1) == '*') {
                    m--;
                }

                dp[n][m] = matchDPTopDown(s, n - 1, p, m, dp) ||
                           matchDPTopDown(s, n, p, m - 1, dp);
            } else {
                if (p.charAt(m) != s.charAt(n) && p.charAt(m) != '?') {
                    dp[n][m] = false;
                }
                else {
                    dp[n][m] = matchDPTopDown(s, n - 1, p, m - 1, dp);
                }
            }
        }

        return dp[n][m];
    }

    public boolean isMatchDPBottomUp(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case empty string always match
        dp[0][0] = true;

        //           ""
        //           "ab*a*b"
        // dp[0][j]  1000000
        //           "******"
        // dp[0][j]  1111111
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    // abcd X abc* = (abc X abc*) || (abcd X abc)
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    // abcd X abc? = abc X abc
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}
