

class Solution {
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return helper(0, 0, triangle);
    }

    private int helper(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = helper(i + 1, j, triangle);
        int diag = helper(i + 1, j + 1, triangle);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
    }
}