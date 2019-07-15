package cs.hacking.ds_algo.leetcode.ti;

/**
 * 1. substring version is good
 * 2. no need to find shortest string, just select
 *    first string
 */
public class LongestCommonPrefix {
    public String solution(String[] in) {
        if (in == null || in.length == 0) {
            return "";
        }

        int len = Integer.MAX_VALUE;
        for (String s : in) {
            if (s.length() < len) {
                len = s.length();
            }
        }

        char[] buf = new char[len];
        int i = 0;
        char c = 0;

        while (i < len) {
            for (int j = 0; j < in.length; j++) {
                if (j == 0) {
                    c = in[j].charAt(i);
                } else if (c != in[j].charAt(i)) {
                    return new String(buf, 0, i);
                }
            }

            buf[i] = c;
            i++;
        }

        return new String(buf, 0, i);
    }
}
