class Solution {
    public int[] dp;

    public int helper(int n){
        
        if(n<=2){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        int firstStep =helper(n-1);
        int secondStep = helper(n-2);

        return dp[n]= firstStep + secondStep;
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n);
        
    }
}