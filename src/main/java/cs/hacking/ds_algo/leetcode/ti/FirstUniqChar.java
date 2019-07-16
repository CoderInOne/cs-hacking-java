package cs.hacking.ds_algo.leetcode.ti;

public class FirstUniqChar {
    // TODO fast and slow ptr
    public int solve(String input) {
        int[] freq = new int[26];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i) - 'a'] += 1;
        }
        for (int j = 0; j < input.length(); j++) {
            if (freq[input.charAt(j) - 'a'] == 1) {
                return j;
            }
        }
        return -1;
    }
}
