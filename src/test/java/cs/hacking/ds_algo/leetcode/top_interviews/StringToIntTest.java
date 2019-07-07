package cs.hacking.ds_algo.leetcode.top_interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class StringToIntTest {
	private Map<String, Integer> testMap;

	@Before
	public void setUp() {
		testMap = new HashMap<>();
		testMap.put("a", 0);
		testMap.put("   111", 111);
		testMap.put("456xxx", 456);
		testMap.put("-345", -345);
		testMap.put("-345xxx", -345);
		testMap.put("  -345", -345);
		testMap.put("2147483648", Integer.MAX_VALUE);
		testMap.put("2147483647", Integer.MAX_VALUE);
		testMap.put("-2147483648", Integer.MIN_VALUE);
		testMap.put("-2147483649", Integer.MIN_VALUE);
		testMap.put("0-1", 0);
		testMap.put("1-1", 1);
		testMap.put("-5-", -5);
		testMap.put(" ", 0);
		testMap.put("words and 987", 0);
	}

	@Test
	public void str2int() {
		// System.out.println(Integer.MAX_VALUE / 10);

		StringToInt stringToInt = new StringToInt();
		for (Map.Entry<String, Integer> e : testMap.entrySet()) {
			int res = stringToInt.str2int(e.getKey());
			assertEquals(String.format("input:%s, output:%d, expect:%d", e.getKey(), res, e.getValue()),
					e.getValue().intValue(), res);
		}
	}
}