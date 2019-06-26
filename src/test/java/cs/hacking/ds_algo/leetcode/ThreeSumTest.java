package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.ThreeSum;
import org.junit.Test;

public class ThreeSumTest {

	@Test
	public void brutal() {
		int nums[] = new int[]{-1, 0, 1, 2, -1, -4};

		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.brutal(nums));
	}

	@Test
	public void better() {
		int nums[] = new int[]{-2, -1, 0, 1, 1, 2, 2, 3};

		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.better(nums));
	}

	@Test
	public void zeroSet() {
		int nums[] = new int[]{0, 0, 0, 0};

		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.better(nums));
	}

	@Test
	public void test3() {
		int nums[] = new int[]{1, -1, -1, 0};

		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.better(nums));
	}
}