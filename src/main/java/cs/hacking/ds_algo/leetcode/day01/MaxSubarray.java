package cs.hacking.ds_algo.leetcode.day01;

/**
 * TODO divide and conquer
 */
public class MaxSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int s = nums[0];
		int m = nums[0];
		for (int i = 1; i < nums.length; i++) {
			m = Math.max(m + nums[i], nums[i]);
			if (m > s) {
				s = m;
			}
		}
		return s;
	}
}
