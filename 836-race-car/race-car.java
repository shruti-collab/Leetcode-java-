import java.util.Arrays;

class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= target; i++) {
            int m = 1;
            int distance = (1 << m) - 1;
            
            while (distance < i) {
                // Fix: j < m instead of j < m - 1 to cover all valid backward steps
                for (int j = 0; j < m; j++) {
                    int backDistance = (1 << j) - 1;
                    int moves = m + 1 + j + 1;
                    dp[i] = Math.min(dp[i], moves + dp[i - (distance - backDistance)]);
                }
                m++;
                distance = (1 << m) - 1;
            }
            
            if (distance == i) {
                dp[i] = m;
            } else {
                dp[i] = Math.min(dp[i], m + 1 + dp[distance - i]);
            }
        }
        
        return dp[target];
    }
}