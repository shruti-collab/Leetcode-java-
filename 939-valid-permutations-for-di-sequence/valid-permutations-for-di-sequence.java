class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;

        // dp[i][j] stores the number of valid permutations of length i + 1
        // ending with the j-th smallest available digit.
        int[][] dp = new int[n + 1][n + 1];

        // Base case: 1 way to have a sequence of length 1 (using digit 0)
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);

            if (ch == 'D') {
                int curSum = 0;
                for (int j = i - 1; j >= 0; j--) {
                    curSum = (curSum + dp[i - 1][j]) % MOD;
                    dp[i][j] = curSum;
                }
            } else { // ch == 'I'
                int curSum = 0;
                for (int j = 0; j < i; j++) {
                    curSum = (curSum + dp[i - 1][j]) % MOD;
                    dp[i][j + 1] = curSum;
                }
            }
        }

        int total = 0;
        for (int j = 0; j <= n; j++) {
            total = (total + dp[n][j]) % MOD;
        }

        return total;
    }
}