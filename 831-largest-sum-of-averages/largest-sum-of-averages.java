class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] prefixSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        double[][] dp = new double[n + 1][k + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i] / i;
        }
        
        for (int p = 2; p <= k; p++) {
            for (int i = p; i <= n; i++) {
                for (int j = p - 1; j < i; j++) {
                    dp[i][p] = Math.max(dp[i][p], dp[j][p - 1] + (prefixSum[i] - prefixSum[j]) / (i - j));
                }
            }
        }
        
        return dp[n][k];
    }
}