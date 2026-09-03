class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // dp[i][j] stores the minimum ASCII delete sum for s1[0...i-1] and s2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Base case: s2 is empty, delete all remaining characters of s1
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        
        // Base case: s1 is empty, delete all remaining characters of s2
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Characters match: no deletion needed for these positions
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Min cost of deleting either character s1[i-1] or s2[j-1]
                    dp[i][j] = Math.min(
                        dp[i - 1][j] + s1.charAt(i - 1),
                        dp[i][j - 1] + s2.charAt(j - 1)
                    );
                }
            }
        }
        
        return dp[m][n];
    }
}