package cs.hacking.ds_algo.leetcode.day00;

import java.util.Arrays;

public class FindDuplicate {
	public int crude(int[] nums) {
		if (nums == null || nums.length == 1) {
			return -1;
		}

		Arrays.sort(nums);
		int p = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (p == nums[i]) {
				return p;
			}
			else {
				p = nums[i];
			}
		}

		return -1;
	}

	public int pigeonholePrinciple(int[] nums) {
		int low = 1;
		int high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			int count = 0;
			for (int i : nums) {
				if (i <= mid) {
					count++;
				}
			}

			if (count > mid) {
				high = mid;
			}
			else {
				low = mid + 1;
			}
		}

		return low;
	}

	public int slowFast(int[] nums) {
		int slow = 0;
		int fast = 0;

		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];

			if (slow == fast) {
				break;
			}
		}

		int finder = 0;
		while (true) {
			slow = nums[slow];
			finder = nums[finder];

			if (slow == finder) {
				return slow;
			}
		}
	}
}
