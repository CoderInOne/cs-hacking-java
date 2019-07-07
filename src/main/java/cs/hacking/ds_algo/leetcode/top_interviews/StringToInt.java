package cs.hacking.ds_algo.leetcode.top_interviews;

/**
 * Compare to JDK implementation, this one is more elegant
 * check java.lang.Integer#parseInt(java.lang.String, int)
 */
public class StringToInt {
	public int str2int(String s) {
        int res = 0, i = 0, sign = 1;
        char[] cs = s.toCharArray();
        int threshold = 214748364;

        if (cs.length == 0) {
        	return 0;
		}

        // skip whitespace
		while (i < cs.length && cs[i] == ' ') {
        	i++;
		}

		// compute sign
		if (i < cs.length && (cs[i] == '+' || cs[i] == '-')) {
			sign = 1 - 2 * (cs[i++] == '-' ? 1 : 0);
		}

		while (i < cs.length && cs[i] >= '0' && cs[i] <= '9') {
        	if (res > threshold || (res == threshold && (cs[i] - '0') > 7)) {
        		return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

        	res = res * 10 + (cs[i++] - '0');
		}

		return res * sign;
	}
}
