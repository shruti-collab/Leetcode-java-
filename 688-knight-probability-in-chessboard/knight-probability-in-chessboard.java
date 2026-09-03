class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // 8 possible moves for a chess knight
        int[][] directions = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };

        // dp[r][c] stores the probability of being on cell (r, c)
        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        for (int step = 1; step <= k; step++) {
            double[][] nextDp = new double[n][n];
            
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] dir : directions) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            
                            // Check if the move stays on the board
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                nextDp[nr][nc] += dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        // Sum up probabilities for all valid positions on the board after k moves
        double totalProbability = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                totalProbability += dp[r][c];
            }
        }

        return totalProbability;
    }
}