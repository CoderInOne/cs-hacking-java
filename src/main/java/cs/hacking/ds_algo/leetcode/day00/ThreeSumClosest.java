package cs.hacking.ds_algo.leetcode.day00;

import java.util.Arrays;
import java.util.Map;

public class ThreeSumClosest {
	public int solution(int nums[], int target) {
		if (nums == null || nums.length < 3) {
			throw new IllegalArgumentException("array length should be larger than 2");
		}

		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {
			int c = target - nums[i];

			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				int d = nums[low] + nums[high] - c;
				if (Math.abs(d) < min) {
					min = Math.abs(d);
					res = nums[i] + nums[low] + nums[high];
				}

				if (d == 0) {
					return target;
				}
				else if (d < 0) {
					low++;
				}
				else {
					high--;
				}
			}
		}

		return res;
	}
}
