class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];

        java.util.function.IntUnaryOperator solve = new java.util.function.IntUnaryOperator() {
            @Override
            public int applyAsInt(int rem) {
                if (rem == 0) return 0;
                if (rem < 0) return Integer.MAX_VALUE / 2;
                if (dp[rem] != null) return dp[rem];

                int ans = Integer.MAX_VALUE / 2;
                for (int c : coins) {
                    ans = Math.min(ans, 1 + applyAsInt(rem - c));
                }
                dp[rem] = ans;
                return ans;
            }
        };

        int res = solve.applyAsInt(amount);
        return res >= Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
