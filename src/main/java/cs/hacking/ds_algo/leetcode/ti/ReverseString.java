package cs.hacking.ds_algo.leetcode.ti;

public class ReverseString {
    public void solve(char[] cs) {
        char t;
        for (int i = 0; i < cs.length / 2; i++) {
            t = cs[i];
            cs[i] = cs[cs.length - i - 1];
            cs[cs.length - i - 1] = t;
        }
    }
}
