package cs.hacking.ds_algo.strings;

import cs.hacking.ds_algo.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class StringMatchTest {

	private StringMatcher strMatcher;

	@Before
	public void setUp() throws Exception {
		strMatcher = new StringMatcher();
	}

	@Test
	public void matchDistinctCharsPattern() {
		Map<String, List<Integer>> testMap = new LinkedHashMap<>();
		String pattern = "abcd";
		testMap.put("abcbcbabccdabcdabc", Collections.singletonList(11));
		testMap.put("abcbcbabccdabcdabcabcd", Arrays.asList(11, 18));
		testMap.put("ababcd", Collections.singletonList(2));
		testMap.put("abc", Collections.emptyList());
		testMap.put("abcd", Collections.singletonList(0));
		testMap.put("aabcd", Collections.singletonList(1));

		for (Map.Entry<String, List<Integer>> e : testMap.entrySet()) {
			List<Integer> res = strMatcher.matchDistinctCharsPattern(e.getKey(), pattern);
			assertArrayEquals(String.format("fail input:%s, output:%s, expect:%s",
					e.getKey(), res, e.getValue()),
					e.getValue().toArray(), res.toArray());
		}
	}

	@Test
	public void robinKarp() {
		Map<String, List<Integer>> testMap = new LinkedHashMap<>();
		String pattern = "1234";
		testMap.put("1234", Collections.singletonList(0));
		testMap.put("1234123", Collections.singletonList(0));
		testMap.put("12123412", Collections.singletonList(2));
		testMap.put("121234123422", Arrays.asList(2, 6));
		testMap.put("1212344123422", Arrays.asList(2, 7));

		for (Map.Entry<String, List<Integer>> e : testMap.entrySet()) {
			List<Integer> res = strMatcher.robinKarp(e.getKey(), pattern, 10, 11);
			assertArrayEquals(String.format("fail input:%s, output:%s, expect:%s",
					e.getKey(), res, e.getValue()),
					e.getValue().toArray(), res.toArray());
		}
	}

	@Test
	public void fsm() {
		Map<String, List<Integer>> testMap = new LinkedHashMap<>();
		String pattern = "abcd";
		testMap.put("abcd", Collections.singletonList(0));
		testMap.put("abc", Collections.emptyList());
		testMap.put("aabcd", Collections.singletonList(1));
		testMap.put("ababcd", Collections.singletonList(2));
		testMap.put("abcbcbabccdabcdabc", Collections.singletonList(11));
		testMap.put("abcbcbabccdabcdabcabcd", Arrays.asList(11, 18));

		for (Map.Entry<String, List<Integer>> e : testMap.entrySet()) {
			List<Integer> res = strMatcher.fsm(e.getKey(), pattern);
			assertArrayEquals(String.format("fail input:%s, output:%s, expect:%s",
					e.getKey(), res, e.getValue()),
					e.getValue().toArray(), res.toArray());
		}
	}

	@Test
	public void computeTfFsm() {
		String p = "abcd";
		Map<Pair<Integer, Integer>, Integer> tf = new HashMap<>(p.length() + 1);
//		strMatcher.computeTf(tf, p);
//		System.out.println(tf);
//		tf.get(Pair.from(0, 97));
		assertEquals(1, (int) tf.get(Pair.from(0, 97)));
		assertEquals(1, (int) tf.get(Pair.from(1, 97)));
		assertEquals(1, (int) tf.get(Pair.from(2, 97)));
	}
}