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
		for (int i = 0; i <= s.length() - p.length(); i++) {
			if (s.charAt(i) == p.charAt(0)) {
				int jump = -1;
				for (int j = 1; j < p.length(); j++) {
					if (s.charAt(i+j) != p.charAt(j)) {
						jump = s.charAt(i+j) == p.charAt(0) ? j - 1 : j;
						break;
					}
				}
				// no jump means match found
				if (jump == -1) {
					res.add(i);
					i += p.length() - 1;
				}
				else {
					i += jump;
				}
			}
		}
		return res;
	}
}
