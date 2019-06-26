package cs.hacking.ds_algo.leetcode.day00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * how to abstract to k sum problem
 * 1. k -> k-1 problem
 * 2. reduce to 2 sum problem
 * 3. use recursive
 * 4. sort help optimization
 * TODO generalize
 */
public class FourSum {
	public List<List<Integer>> solution(int nums[], int target) {
		Arrays.sort(nums);
		int i = 0;
		List<List<Integer>> res = new ArrayList<>();
		while (i < nums.length - 3) {
			// skip when meet duplicate next element
			if (i == 0 || nums[i-1] != nums[i]) {
				int c = target - nums[i];
				List<List<Integer>> l = threeSum(nums, i + 1, c, nums[i]);
				res.addAll(l);
			}

			i++;
		}

		return res;
	}

	private List<List<Integer>> threeSum(int[] nums, int start, int t, int f) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = start; i < nums.length - 2; i++) {
			// match nums[low] + nums[high] = target
			int target = t - nums[i];
			int low = i + 1;
			int high = nums.length - 1;

			while (low < high) {
				if (nums[low] + nums[high] == target) {
					res.add(Arrays.asList(f, nums[i], nums[low], nums[high]));

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
