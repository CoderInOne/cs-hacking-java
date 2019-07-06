package cs.hacking.ds_algo.leetcode;

import org.junit.Test;

public class IntegerTest {
	@Test
	public void parsing() {
		String s = "-1";
		Integer.valueOf("2147483648");
	}

    @Test
    public void bitCount() {
        int c = Integer.bitCount(1);
        System.out.println(c);
        c = Integer.bitCount(7);
        System.out.println(c);
    }

    @Test
    public void leftShift() {
        System.out.println(64 * 1);
        System.out.println(1 << 6);
    }
}
