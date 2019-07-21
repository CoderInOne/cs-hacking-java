package cs.hacking.ds_algo.leetcode.ti;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesesTest {

    @Test
    public void solve() {
        int n = 3;
        GenerateParentheses gp = new GenerateParentheses();
        List<String> res = gp.solve(n);
        System.out.println(res);
    }
}