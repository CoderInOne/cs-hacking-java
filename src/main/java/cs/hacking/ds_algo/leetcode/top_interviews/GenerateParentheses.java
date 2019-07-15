package cs.hacking.ds_algo.leetcode.top_interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * The idea is simple, but something stuck me to implement my idea.
 * So I just learn other's solution. It's very simple solution by recursive.
 */
public class GenerateParentheses {
    public List<String> solve(int N) {
        List<String> res = new ArrayList<>();
        char[] buf = new char[N * 2];
        buf[0] = '(';
        doSolve(res, buf, 1, N - 1, 1);
        return res;
    }

    private void doSolve(List<String> res, char[] buf, int b, int n, int p) {
        if (p == buf.length) {
            res.add(new String(buf));
            return;
        }

        if (n != 0) {
            buf[p] = '(';
            doSolve(res, buf, b + 1, n - 1, p + 1);
        }

        if (b != 0) {
            buf[p] = ')';
            doSolve(res, buf, b - 1, n, p + 1);
        }
    }
}
