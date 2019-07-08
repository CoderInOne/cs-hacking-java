package cs.hacking.ds_algo.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Even you're so confident of your code, you should walk the code
 * line by line. How do you confirm that you code is perfect?
 * People is not born as perfect
 * Check MARKING place that I make mistake
 *
 * TODO string matching complexity and theory
 */
public class KMP {
    public List<Integer> matching(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int[] tf = computeTf(p);
        int i = 0;
        int j = 0;

        while (i < s.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }

            if (j == p.length()) {
                // MARKING forget to collect result
                // MARKING again: i - p.length() + 1, track i's value carefully
                res.add(i - p.length());
                j = tf[tf.length - 1];
            }
            else if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = tf[j - 1];
                }
                else {
                    i++;
                }
            }
        }

        return res;
    }

    int[] computeTf(String p) {
        int[] tf = new int[p.length()];
        int len = 0;
        tf[len] = 0;
        int i = 1;

        while (i < p.length()) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                tf[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = tf[len - 1];
                }
                else {
                    tf[i] = 0;
                    i++;
                }
            }
        }

        return tf;
    }
}
