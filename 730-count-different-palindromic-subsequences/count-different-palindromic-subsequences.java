class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int MOD = 1000000007;
        
        // dp[i][j] stores the number of distinct palindromic subsequences in s[i...j]
        int[][] dp = new int[n][n];

        // Base case: single length characters are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill table by length of substring
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    int low = i + 1;
                    int high = j - 1;

                    // Find first and last occurrences of s[i] inside substring s[i+1 ... j-1]
                    while (low <= high && s.charAt(low) != s.charAt(i)) {
                        low++;
                    }
                    while (low <= high && s.charAt(high) != s.charAt(i)) {
                        high--;
                    }

                    if (low > high) {
                        // Case 1: No inner character matching s[i]
                        // e.g., "a...a" with no 'a' inside
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 2) % MOD;
                    } else if (low == high) {
                        // Case 2: Exactly one inner character matching s[i]
                        // e.g., "a...a...a"
                        dp[i][j] = (dp[i + 1][j - 1] * 2 + 1) % MOD;
                    } else {
                        // Case 3: Two or more inner characters matching s[i]
                        // e.g., "a...a...a...a"
                        dp[i][j] = (dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1]) % MOD;
                    }
                } else {
                    // Ends do not match
                    dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]) % MOD;
                }

                // Handle negative modulus operations
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }

        return dp[0][n - 1];
    }
}