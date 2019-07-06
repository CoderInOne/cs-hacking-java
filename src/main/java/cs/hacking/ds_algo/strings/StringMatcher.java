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
					if (s.charAt(i + j) != p.charAt(j)) {
						i += j;
						break;
					}

					if (j == p.length() - 1) {
						res.add(i);
						i += p.length();
					}
				}
			} else {
				i++;
			}
		}
		return res;
	}

	public List<Integer> robenKarp(String s, String p, int d, int q) {
		List<Integer> res = new ArrayList<>();
		int hp = 0;
		int hs = 0;
		int h = d;

		for (int i = 0; i < p.length() - 1; i++) {
			h = (h * d) % q;
		}

		// pre process
		for (int j = 0; j < p.length(); j++) {
			hp = (hp * d + p.charAt(j)) % q;
			hs = (hs * d + s.charAt(j)) % q;
		}

		for (int k = 0; k <= s.length() - p.length(); k++) {
			if (hs == hp) {
				for (int t = 0; t < p.length(); t++) {
					if (s.charAt(t + k) != p.charAt(t)) {
						break;
					} else if (t == p.length() - 1) {
						res.add(k);
					}
				}
			} else if (k + 1 <= s.length() - p.length()) {
				hs = (d * (hs - s.charAt(k) * h + s.charAt(k + 1))) % q;
			}
		}

		return res;
	}
}
