package cs.hacking.ds_algo.leetcode;

import cs.hacking.ds_algo.leetcode.day00.FourSum;
import org.junit.Test;

import java.util.List;

public class FourSumTest {

	@Test
	public void solution() {
		FourSum fourSum = new FourSum();

		List<List<Integer>> res = fourSum.solution(new int[]{1, 0, -1, 0, -2, 2}, 0);
		System.out.println(res);
	}
}