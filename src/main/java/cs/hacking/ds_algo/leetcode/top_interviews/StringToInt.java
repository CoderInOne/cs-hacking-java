package cs.hacking.ds_algo.leetcode.top_interviews;

public class StringToInt {
	public int str2int(String s) {
        Integer res = null;
        int i = 0;
        int flag = 0;
        char[] cs = s.toCharArray();
        int threshold = 214748364;

        if (cs.length == 0) {
        	return 0;
		}

        // skip whitespace
		while (i < cs.length && cs[i] == ' ') {
        	i++;
		}

		for (; i < cs.length; i++) {
        	char c = cs[i];
        	if (c == '+' || c == '-') {
        		if (res != null || flag != 0) {
        			break;
				}
				flag = c == '-' ? -1 : 1;
			}
			else if (c - '0' >= 0 && c <= '9') {
        		int n = c - '0';
        		if (res == null) {
        			res = n;
				}
				else {
        			// check overflow
					if (flag == -1) {
						if (res > threshold || (res == threshold && n > 8)) {
							return Integer.MIN_VALUE;
						}
					}
					else if (res > threshold || (res == threshold && n > 7)) {
						return Integer.MAX_VALUE;
					}

					res = res * 10 + n;
				}
			}
			else {
        		break;
			}
		}

		return res == null ? 0 : res * (flag == 0 ? 1 : flag);
	}
}
