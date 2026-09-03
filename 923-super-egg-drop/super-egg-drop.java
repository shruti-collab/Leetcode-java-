class Solution {
    public int superEggDrop(int k, int n) {
        // dp[i] will store the max floors that can be tested with current number of moves and 'i' eggs
        int[] dp = new int[k + 1];
        int moves = 0;

        // Keep making moves until we can cover at least n floors
        while (dp[k] < n) {
            moves++;
            // Update dp array backwards to use values from previous move (m - 1)
            for (int i = k; i > 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
        }

        return moves;
    }
}