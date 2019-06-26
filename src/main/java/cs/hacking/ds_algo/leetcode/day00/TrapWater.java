package cs.hacking.ds_algo.leetcode.day00;

public class TrapWater {
	int trap(int nums[]) {
		int s = 0;
		int b = 0;
		int low = 0;
		int high = nums.length - 1;
		while (low < high - 1) {
			int t = Math.min(nums[low], nums[high]);
			for (int i = low + 1; i < high; i++) {
				if (nums[i] < t) {
					s += t - Math.max(b, nums[i]);
				}
			}

			while (low < high - 1 && nums[low] <= t) {
				low++;
			}
			while (low < high - 1 && nums[high] <= t) {
				high--;
			}

			b = t;
		}

		return s;
	}

	public int trap1(int nums[]) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int maxLeft = nums[0];
		int maxRight = nums[nums.length - 1];
		int low = 0;
		int high = nums.length - 1;
		int s = 0;

		while (low <= high) {
			if (maxLeft <= maxRight) {
				if (nums[low] >= maxLeft) {
					maxLeft = nums[low];
				}
				else {
					s += maxLeft - nums[low];
				}
				low++;
			} else {
				if (nums[high] >= maxRight) {
					maxRight = nums[high];
				}
				else {
					s += maxRight - nums[high];
				}
				high--;
			}
		}

		return s;
	}
}
