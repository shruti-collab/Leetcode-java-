class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)return 0;
        dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
       return helper(obstacleGrid,0,0); 
    }
    public int helper(int[][] obstacleGrid,int r,int c){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //  obstacle(boundary condition)
        if (r >= m || c >= n || obstacleGrid[r][c] == 1) return 0;

        // reached destination
        if (r == m - 1 && c == n - 1) return 1;

        // move right + down
        if(dp[r][c]!=0)return dp[r][c];
        dp[r][c]= helper(obstacleGrid, r + 1, c) + helper(obstacleGrid, r, c + 1);
        return dp[r][c];
    }
}