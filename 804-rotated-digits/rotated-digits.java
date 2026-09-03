class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        // dp[i] status:
        // 0: invalid rotation (contains 3, 4, or 7)
        // 1: valid and same as original (composed only of 0, 1, 8)
        // 2: valid and different from original (contains at least one 2, 5, 6, or 9)
        int[] dp = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            if (i < 10) {
                if (i == 0 || i == 1 || i == 8) {
                    dp[i] = 1;
                } else if (i == 2 || i == 5 || i == 6 || i == 9) {
                    dp[i] = 2;
                    count++;
                } else {
                    dp[i] = 0; // 3, 4, 7
                }
            } else {
                int a = dp[i / 10];
                int b = dp[i % 10];
                
                // If any part is invalid (0), the whole number is invalid
                if (a == 0 || b == 0) {
                    dp[i] = 0;
                } 
                // If both parts are unchanged (1), the number is unchanged
                else if (a == 1 && b == 1) {
                    dp[i] = 1;
                } 
                // Otherwise, it's valid and contains at least one rotated digit
                else {
                    dp[i] = 2;
                    count++;
                }
            }
        }
        
        return count;
    }
}