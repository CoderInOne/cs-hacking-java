package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.ProductExceptSelf;
import org.junit.Test;

import java.util.Arrays;

public class ProductExceptSelfTest {

	@Test
	public void productExceptSelf() {
		int nums[] = new int[]{1, 2, 3, 4};
		ProductExceptSelf app = new ProductExceptSelf();
		int[] ints = app.productExceptSelf(nums);
		System.out.println(Arrays.toString(ints));
	}
}