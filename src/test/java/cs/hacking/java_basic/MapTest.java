package cs.hacking.java_basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
	@Test
	public void iteration() {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);

		System.out.println("entry set");
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.println(e.getValue());
		}

		System.out.println("iterator");
		Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next().getValue());
		}

		System.out.println("java8 foreach");
		map.forEach((k, v) -> {
			System.out.println(v);
		});
	}
}