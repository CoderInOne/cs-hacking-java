package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.MaxArea;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxAreaTest {

	@Test
	public void maxArea() {
		int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
		MaxArea maxArea = new MaxArea();
		assertEquals(49, maxArea.maxArea(heights));
	}

	@Test
	public void maxArea1() {
		int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
		MaxArea maxArea = new MaxArea();
		assertEquals(49, maxArea.maxArea1(heights));
	}
}