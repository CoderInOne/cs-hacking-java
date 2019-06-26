package cs.hacking.ds_algo.leetcode.day00;

import java.util.*;

/**
 * note that we need all possible result
 */
public class ThreeSum {
	public List<List<Integer>> brutal(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(nums[i]);
						l.add(nums[j]);
						l.add(nums[k]);
						res.add(l);
					}
				}
			}
		}
		return res;
	}

	/**
	 * can not solve duplicated solution
	 * forget about hash map
	 */
	public List<List<Integer>> better(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return Collections.emptyList();
		}

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) {
				return res;
			}

			// match nums[low] + nums[high] = target
			int target = -nums[i];
			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				if (nums[low] + nums[high] == target) {
					res.add(Arrays.asList(nums[i], nums[low], nums[high]));

					// skip duplicates
					while (low < high && nums[low] == nums[low+1]) {
						low++;
					}
					while (low < high && nums[high] == nums[high-1]) {
						high--;
					}

					low++;
					high--;
				}
				else if (nums[low] > target - nums[high]) {
					high--;
				}
				else {
					low++;
				}
			}

			while (nums[i] == nums[i+1] && i < nums.length - 2) {
				i++;
			}
		}

		return res;
	}
}
