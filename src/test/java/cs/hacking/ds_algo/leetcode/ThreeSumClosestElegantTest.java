package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.ThreeSumClosestElegant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeSumClosestElegantTest {

	@Test
	public void solution() {
		int[] nums = new int[] { -1, 2, 1, -4 };
		ThreeSumClosestElegant threeSumClosest = new ThreeSumClosestElegant();
		assertEquals(2, threeSumClosest.solution(nums, 1));
		assertEquals(3, threeSumClosest.solution(new int[] {1, 2, 1, 1}, 3));
		assertEquals(3, threeSumClosest.solution(new int[] {0, 1, 2}, 0));
	}
}