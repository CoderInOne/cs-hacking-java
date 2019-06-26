package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.TrapWater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrapWaterTest {
	@Test
	public void trap1() {
		TrapWater trapWater = new TrapWater();
		assertEquals(0, trapWater.trap1(new int[] {2, 1, 0, 0}));
		assertEquals(2, trapWater.trap1(new int[] {2, 0, 3}));
		assertEquals(13, trapWater.trap1(new int[] {3, 0, 2, 0, 4, 0, 2, 4}));
		assertEquals(8, trapWater.trap1(new int[] {1, 0, 2, 0, 1, 0, 3, 0, 2}));
	}
}