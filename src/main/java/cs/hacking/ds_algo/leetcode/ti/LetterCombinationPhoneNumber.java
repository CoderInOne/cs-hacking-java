package cs.hacking.ds_algo.leetcode.ti;

public class LetterCombinationPhoneNumber {
    /**
     * d ->
     *   0   1   2      3
     * { "", "", "abc", "def"}
     *
     * l = [""]
     * for x in t:
     *   tmp = l
     *   l.clear()
     *   for c in d[toValue(x)]:
     *     for s in tmp:
     *       l.add(s + c)
     *
     * ret l
     * -----------------------
     * test
     * IN [2]     "a" "b" "c"
     *    [23]    "ad" "bd" "cd" "ae" "be" "ce" "af" "bf" "cf"
     */
}
