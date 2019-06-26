package cs.hacking.ds_algo.leetcode.day00;

public class ProductExceptSelf {
	public int[] productExceptSelf(int nums[]) {
		int res[] = new int[nums.length];
		int p = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = p;
			p *= nums[i];
		}
		p = 1;
		for (int j = nums.length - 1; j >= 0; j--) {
			res[j] *= p;
			p *= nums[j];
		}
		return res;
	}
}
