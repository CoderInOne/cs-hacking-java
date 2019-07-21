package cs.hacking.ds_algo.leetcode.ti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationPhoneNumber {
    /**
     * d ->
     * 0   1   2      3
     * { "", "", "abc", "def"}
     * <p>
     * l = [""]
     * for x in t:
     * tmp = l
     * l.clear()
     * for c in d[toValue(x)]:
     * for s in tmp:
     * l.add(s + c)
     * <p>
     * ret l
     * -----------------------
     * test
     * IN [2]     "a" "b" "c"
     * [23]    "ad" "bd" "cd" "ae" "be" "ce" "af" "bf" "cf"
     */
    public List<String> solve(String in) {
        if (in == null || in.length() == 0) {
            return Collections.emptyList();
        }

        String[] d = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> l = new ArrayList<>();
        l.add("");

        for (char x : in.toCharArray()) {
            String s = d[x - '0'];

            char[] a = s.toCharArray();
            int len = l.size();

            // [a, b, c]
            // [a, b, c, ad, bd, cd, ae, be, ce]
            // [af, bf, cf, ad, bd, cd, ae, be, ce]
            for (int i = 0; i < a.length; i++) {
                char c = a[i];

                // [a, b, c]
                // [ad, bd, cd]
                for (int j = 0; j < len; j++) {
                    if (i == a.length - 1) {
                        // append to old str
                        l.set(j, l.get(j) + c);
                    } else {
                        l.add(l.get(j) + c);
                    }
                }
            }
        }

        return l;
    }
}
