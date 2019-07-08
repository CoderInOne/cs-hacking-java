package cs.hacking.ds_algo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PairTest {
	@Test
	public void hashTest() {
		Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

		Pair<Integer, Integer> p2 = Pair.from(1, 97);
		map.put(p2, 1);

		System.out.println(hash(Pair.from(1, 97)));
		System.out.println(hash(Pair.from(1, 'a')));

		System.out.println(map.get(Pair.from(1, 'a')));
		System.out.println(map.get(Pair.from(1, 97)));
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}