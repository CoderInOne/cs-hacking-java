package cs.hacking.ds_algo.backtracking;

public class NQueens {
    private boolean isSafe(int[][] p, int N, int row, int col) {
        /*
         * 1. same row: [? ? 1]
         * 2. triangle upper left
         * ?
         *   ?
         *     1
         * 3. triangle below left
         *     1
         *   ?
         * ?
         */
        for (int j = 1; j <= col; j++) {
            if (p[row][j - 1] == 1) {
                return false;
            }
            if (row - j >= 0 && p[row - j][col - j] == 1) {
                return false;
            }
            if (row + j < N && p[row + j][col - j] == 1) {
                return false;
            }
        }

        return true;
    }

    public boolean solve(int[][] p, int N, int col) {
        // accept
        if (col >= N) {
            return true;
        }

        // first

        for (int row = 0; row < N; row++) {
            // judge
            if (isSafe(p, N, row, col)) {
                p[row][col] = 1;

                // next
                if (solve(p, N, col + 1)) {
                    return true;
                }

                p[row][col] = 0;
            }
        }

        return false;
    }
}
