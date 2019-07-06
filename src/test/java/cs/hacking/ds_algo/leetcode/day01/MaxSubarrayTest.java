package cs.hacking.ds_algo.leetcode.day01;

import cs.hacking.ds_algo.leetcode.day00.MaxSubarray;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxSubarrayTest {
	@Test
	public void test() {
		MaxSubarray maxSubarray = new MaxSubarray();
		assertEquals(0, maxSubarray.maxSubArray(new int[] {0, 0, 0}));
		assertEquals(2, maxSubarray.maxSubArray(new int[] {1, -3, 2}));
		assertEquals(6, maxSubarray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}