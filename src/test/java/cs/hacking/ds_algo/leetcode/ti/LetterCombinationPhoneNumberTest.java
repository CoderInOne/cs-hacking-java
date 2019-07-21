package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterCombinationPhoneNumberTest {

    @Test
    public void solve() {
        LetterCombinationPhoneNumber lcp = new LetterCombinationPhoneNumber();
        String in = "23";
        System.out.println(lcp.solve(in));
    }
}