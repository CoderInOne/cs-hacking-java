package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.TwoSum;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TwoSumTest {
	@Test
	public void genData() {
		Random random = new Random();
		Set<Integer> list = new HashSet<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(random.nextInt(100));
		}
		ArrayList<Integer> l = new ArrayList<Integer>(list);
		Collections.shuffle(l);
		System.out.println(l);
	}

	@Test
	public void crude() {
		int[] nums = {2, 7, 11, 15};
		TwoSum twoSum = new TwoSum();
		int[] res = twoSum.crude(nums, 26);
		assertArrayEquals(new int[]{2, 3}, res);

		assertNull(twoSum.crude(nums, 20));
	}

	@Test
	public void hashMap() {
		int[] nums = {9,58,56,39,80,97,58,74,72,69,48,33,15,4,73,40,7,29,47,11,71,2,13,47,10,68,30,10,13,52,19,76,3,28,23,66,44,36,87,42,53,17,64,33,80,39,49,81,24,15,34,12,53,92,57,82,78,36,29,87,71,31,57,32,61,3,25,96,9,31,16,36,86,85,48,73,51,72,39,50,1,63,26,0,25,56,17,10,67,29,46,86,20,81,28,27,82,9,56};
		TwoSum twoSum = new TwoSum();
		int[] res = twoSum.hashMap(nums, 24);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}
}