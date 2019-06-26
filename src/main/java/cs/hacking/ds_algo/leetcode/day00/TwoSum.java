package cs.hacking.ds_algo.leetcode.day00;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] crude(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}

		return null;
	}

	public int[] hashMap(int [] nums, int target) {
		if (nums == null || nums.length < 2) {
			return null;
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(nums[0], 0);
		for (int i = 1; i < nums.length; i++) {
			Integer rec = map.get(target - nums[i]);
			if (rec == null) {
				map.put(nums[i], i);
			}
			else {
				return new int[] {rec, i};
			}
		}

		return null;
	}
}
