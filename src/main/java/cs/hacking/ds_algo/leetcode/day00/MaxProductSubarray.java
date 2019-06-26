package cs.hacking.ds_algo.leetcode.day00;

/**
 * hard to see pattern
 */
public class MaxProductSubarray {
	public int solution(int nums[]) {
		int l = solve(nums, 0, nums.length - 1, 1);
		int r = solve(nums, nums.length - 1, 0, -1);
		return l > r ? l : r;
	}

	private int solve(int nums[], int start, int end, int step) {
		return 0;
	}

	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0], min = A[0], result = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
			min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;
	}
}
