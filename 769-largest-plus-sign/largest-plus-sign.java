import java.util.Arrays;

class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        // Initialize grid with n, which is the maximum possible size of contiguous 1s initially
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], n);
        }

        // Mark mines as 0
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }

        // Calculate maximum continuous 1s in 4 directions for every cell
        for (int i = 0; i < n; i++) {
            // Left & Right continuous 1s counter
            int left = 0, right = 0;
            // Up & Down continuous 1s counter
            int up = 0, down = 0;

            for (int j = 0, k = n - 1; j < n; j++, k--) {
                // Left direction
                left = (grid[i][j] == 0) ? 0 : left + 1;
                grid[i][j] = Math.min(grid[i][j], left);

                // Right direction
                right = (grid[i][k] == 0) ? 0 : right + 1;
                grid[i][k] = Math.min(grid[i][k], right);

                // Up direction
                up = (grid[j][i] == 0) ? 0 : up + 1;
                grid[j][i] = Math.min(grid[j][i], up);

                // Down direction
                down = (grid[k][i] == 0) ? 0 : down + 1;
                grid[k][i] = Math.min(grid[k][i], down);
            }
        }

        // Find the maximum order among all cell centers
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, grid[i][j]);
            }
        }

        return ans;
    }
}