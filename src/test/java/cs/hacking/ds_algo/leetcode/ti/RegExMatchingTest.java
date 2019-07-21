package cs.hacking.ds_algo.leetcode.ti;

import cs.hacking.ds_algo.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RegExMatchingTest {
	private Map<Pair<String, String>, Boolean> testMap;
	private final RegExMatching matcher = new RegExMatching();

	@Before
	public void setUp() throws Exception {
		testMap = new LinkedHashMap<>();
		testMap.put(Pair.from("aa", "a*"), true);
		testMap.put(Pair.from("ab", "a."), true);
		testMap.put(Pair.from("aaa", "aaa*"), true);
		testMap.put(Pair.from("ab", ".*"), true);
		testMap.put(Pair.from("aba", ".*"), true);
		testMap.put(Pair.from("aab", "a*a*b"), true);
		testMap.put(Pair.from("aab", "c*a*b"), true);
		testMap.put(Pair.from("a", "ab*b*"), true);
		testMap.put(Pair.from("", "a*"), true);
		testMap.put(Pair.from("aa", "a"), false);
		testMap.put(Pair.from("aaa", "aaaa"), false);
		testMap.put(Pair.from("mississippi", "mis*is*ip*"), false);
		testMap.put(Pair.from("abcd", "d*"), false);
	}

	@Test
	public void isMatch() {
//		for (Map.Entry<Pair<String, String>, Boolean> e : testMap.entrySet()) {
//			assertEquals("fail for " + e, matcher.isMatch(e.getKey().getOne(), e.getKey().getTwo()), e.getValue());
//		}

		assertTrue(matcher.isMatch("aa", "a*"));
		assertTrue(matcher.isMatch("ab", "a."));
		assertTrue(matcher.isMatch("aaa", "aaa*"));
		assertTrue(matcher.isMatch("ab", ".*"));
		assertTrue(matcher.isMatch("aba", ".*"));
		assertTrue(matcher.isMatch("aab", "a*a*b"));
		assertTrue(matcher.isMatch("aab", "c*a*b"));
		assertTrue(matcher.isMatch("a", "ab*b*"));
		assertTrue(matcher.isMatch("", "a*"));

		assertFalse(matcher.isMatch("aa", "a"));
		assertFalse(matcher.isMatch("aaa", "aaaa"));
		assertFalse(matcher.isMatch("mississippi", "mis*is*ip*"));
		assertFalse(matcher.isMatch("abcd", "d*"));
	}

	// FAIL TEST
	@Test
    public void match() {
        assertTrue(matcher.match("aa", "a*"));
        assertTrue(matcher.match("ab", "a."));
        assertTrue(matcher.match("aaa", "aaa*"));
        assertTrue(matcher.match("ab", ".*"));
        assertTrue(matcher.match("aba", ".*"));
        assertTrue(matcher.match("aab", "a*a*b"));
        assertTrue(matcher.match("aab", "c*a*b"));
        assertTrue(matcher.match("a", "ab*b*"));
        assertTrue(matcher.match("", "a*"));

        assertFalse(matcher.match("aa", "a"));
        assertFalse(matcher.match("aaa", "aaaa"));
        assertFalse(matcher.match("mississippi", "mis*is*ip*"));
        assertFalse(matcher.match("abcd", "d*"));
    }
}