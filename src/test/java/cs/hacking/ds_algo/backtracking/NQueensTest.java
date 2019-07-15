package cs.hacking.ds_algo.backtracking;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NQueensTest {
    private NQueens nQueens = new NQueens();

    @Test
    public void solve() {
        int N = 4;
        int[][] p = new int[N][N];
        assertTrue(nQueens.solve(p, N, 0));
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(p[i]));
        }
    }
}