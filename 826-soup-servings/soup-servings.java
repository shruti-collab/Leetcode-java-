class Solution {
    public double soupServings(int n) {
        if (n > 4800) {
            return 1.0;
        }
        
        int m = (n + 24) / 25;
        double[][] dp = new double[m + 1][m + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0.5;
                } else if (i == 0) {
                    dp[i][j] = 1.0;
                } else if (j == 0) {
                    dp[i][j] = 0.0;
                } else {
                    int i1 = Math.max(0, i - 4);
                    int j1 = Math.max(0, j - 0);
                    
                    int i2 = Math.max(0, i - 3);
                    int j2 = Math.max(0, j - 1);
                    
                    int i3 = Math.max(0, i - 2);
                    int j3 = Math.max(0, j - 2);
                    
                    int i4 = Math.max(0, i - 1);
                    int j4 = Math.max(0, j - 3);
                    
                    dp[i][j] = 0.25 * (dp[i1][j1] + dp[i2][j2] + dp[i3][j3] + dp[i4][j4]);
                }
            }
        }
        
        return dp[m][m];
    }
}