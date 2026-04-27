class Solution {
    int[] nums;
    Integer[] dp;

    int solve(int i) {
        if (i >= nums.length) return 0;
        if (dp[i] != null) return dp[i];

        int rob = nums[i] + solve(i + 2);
        int skip = solve(i + 1);

        return dp[i] = Math.max(rob, skip);
    }

    public int rob(int[] nums) {
        this.nums = nums;
        dp = new Integer[nums.length];
        return solve(0);
    }
}
