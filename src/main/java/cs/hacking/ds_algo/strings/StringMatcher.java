package cs.hacking.ds_algo.strings;

import cs.hacking.ds_algo.Pair;

import java.util.*;

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

	public List<Integer> robinKarp(String s, String p, int d, int q) {
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

	public List<Integer> fsm(String s, String p) {
		List<Integer> res = new ArrayList<>();

		// build fsm from p
		// each state accept p.length's input
		// thus has p.length's transfer path possible
		Map<Pair<Integer, Integer>, Integer> tf = new HashMap<>(p.length() + 1);
		computeTf(tf, p);

		// loop into s, when meet final state at i
		// then add solution as i - p.length
		int state = 0;
		for (int i = 0; i < s.length(); i++) {
			state = tf.get(Pair.from(state, (int) s.charAt(i)));
			if (state == p.length()) {
				res.add(i - p.length() + 1);
			}
		}

		return res;
	}

	void computeTf(Map<Pair<Integer, Integer>, Integer> tf, String p) {
//		for (int i = 0; i < tf.length; i++) {
//			for (int j = 0; j < 256; j++) {
//				tf[i][j] = nextState(i, j, p);
//			}
//		}
		Set<Integer> s = new HashSet<>();
		for (int c : p.toCharArray()) {
			s.add(c);
		}

		for (int i = 0; i <= p.length(); i++) {
			for (int c : s) {
				tf.put(Pair.from(i, c), nextState(i, c, p));
			}
		}
	}

	private int nextState(int state, int c, String p) {
		if (state < p.length() && c == p.charAt(state)) {
			return state + 1;
		}

		/**
		 * ns is next potential state, simple idea is
		 *          1 2 3 4 5 6 7
		 *          a b a b a c a
		 * ns = 6   a b a b a
		 *              a b a c a  match last line?
		 *
		 * VERY USEFUL TEST CASE
		 * pattern 			state 	input
		 * abcd    			2     	a
		 * aabcd   			1     	a
		 * ababaca          7       b/a/c
		 */
		for (int ns = state; ns > 0; ns--) {
			if (p.charAt(ns - 1) == c) {
				int i = 0;
				for (; i < ns - 1; i++) {
					if (p.charAt(i) != p.charAt(state - ns + 1 + i)) {
						break;
					}
				}
				if (i == ns - 1) {
					return ns;
				}
			}
		}

		return 0;
	}
}
