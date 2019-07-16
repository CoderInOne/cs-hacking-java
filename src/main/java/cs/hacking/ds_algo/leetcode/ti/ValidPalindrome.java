package cs.hacking.ds_algo.leetcode.ti;

public class ValidPalindrome {
    public boolean solve(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < high && !Character.isAlphabetic(s.charAt(low))) {
                low++;
            }
            while (low < high && !Character.isAlphabetic(s.charAt(high))) {
                high--;
            }

            if (low >= high) {
                return true;
            }

            if (Character.toLowerCase(s.charAt(low))
                    != Character.toLowerCase(s.charAt(high))) {
                return false;
            }

            low++;
            high--;
        }

        return true;
    }
}
