package cs.hacking.ds_algo.leetcode.top_interviews;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * <p>
 * online regex: https://regexr.com/
 * solution: https://leetcode.com/articles/regular-expression-matching/
 */
public class RegExMatching {
	// Recursive solution. It's very hard to see it
	// Next time: think about simple situation - no *
	// High level thinking: recursive pattern
	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		if (p.length() >= 2 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
		}
		else {
			return firstMatch && isMatch(s.substring(1), p.substring(1));
		}
	}

	// TODO DP

	// FAIL CODE
    public boolean match(String s, String p) {
        int i = 0;
        int j = 0;
        while (i <= s.length()) {
            if (i == s.length()) {
                // s consume out, return false?
            }

            if (j >= p.length()) {
                return false;
            }

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*' &&
                    (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.')) {
                i++;
            } else {
                if (j < p.length() - 1) {
                    if (p.charAt(j + 1) == '*') {
                        j += 2;
                    } else if (p.charAt(j) == '*') {
                        j++;
                    }
                } else {
                    return false;
                }
            }
        }

        System.out.println("j:" + j + ",i:" + i + ",p:" + p);

        return j >= p.length() - 1 || (j + 1 == p.length() - 1 && p.charAt(j + 1) == '*');
    }
}
