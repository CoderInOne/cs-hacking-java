package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.FindDuplicate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindDuplicateTest {


	@Test
	public void crude() {
		int[] ints = {1, 3, 4, 2, 2};
		FindDuplicate app = new FindDuplicate();
		assertEquals(2, app.crude(ints));
	}

	@Test
	public void pigeonholePrinciple() {
		int[] ints = {1, 3, 4, 2, 2};
		FindDuplicate app = new FindDuplicate();
		assertEquals(2, app.pigeonholePrinciple(ints));
	}

	@Test
	public void slowFast() {
		/**
		 * 9 1 5 3 6 8 7
		 */
		int[] ints = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
		FindDuplicate app = new FindDuplicate();
		System.out.println(app.slowFast(ints));
	}
}