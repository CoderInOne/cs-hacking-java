package cs.hacking.ds_algo.leetcode.ti;

public class LongestCommonPrefix {
    public String solution(String[] in) {
        /**
         * flower
         * flow
         * flight
         *
         * List<Character> res = new List
         * let i = 0 as current char pos
         * while (true)
         *     for j = [0, in.length):
         *         if (j == 0)
         *             cur = in[j].charAt(i)
         *         else if (i == in[j].length || in[j].charAt(i) != cur)
         *             return new String(in.toArray())
         *     i++
         */
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
                }
                else if (c != in[j].charAt(i)) {
                    return new String(buf, 0, i);
                }
            }

            buf[i] = c;
            i++;
        }

        return new String(buf, 0, i);
    }
}
