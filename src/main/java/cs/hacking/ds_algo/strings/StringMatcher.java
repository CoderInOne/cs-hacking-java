package cs.hacking.ds_algo.strings;

import java.util.ArrayList;
import java.util.List;

public class StringMatcher {
	/**
	 * all char in pattern is distinct
	 * O(n)
	 */
	public List<Integer> matchDistinctCharsPattern(String s, String p) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		while (i <= s.length() - p.length()) {
			if (s.charAt(i) == p.charAt(0)) {
				for (int j = 1; j < p.length(); j++) {
					if (s.charAt(i+j) != p.charAt(j)) {
						i += j;
						break;
					}

					if (j == p.length() - 1) {
						res.add(i);
						i += p.length();
					}
				}
			}
			else {
				i++;
			}
		}
		return res;
	}
}
