package cs.hacking.ds_algo.strings;

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
}