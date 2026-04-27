class Solution {
    public int minDistance(String word1, String word2) {

        int m= word1.length();
        int n =word2.length();

        int [][]dp= new int [m+1][n+1];
        for(int i=0;i<=m;i++)dp[i][0]=i;
        
        for(int j=1;j<=n;j++)dp[0][j]=j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                else {
                    dp[i][j] = 1 + Math.min( dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}








//     }
        
//         for (int i=1;i<m;i++){
//             for(j=1;j<n;j++){
//                 if(word1.word)

//             }
//         }


//         if(i==0){
//            return  word2.length()-j;
//         }
//         if(j==0){
//             return word1.length()-i;
//         }

//         if(word1.charAt[i-1] == word2.charAt[j-1]){
//             dp[i][j] == dp[i-1][j-1];
            
//         }
//         if(dp[i][j]!=dp[i-1][j-1]){
//             dp[i-1][j-1]+1
            

//         }
        
        
        
//     }
// }





// class Solution {
//     public int minDisstance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();

//         int[][] dp = new int[n + 1][m + 1];
//         for(int i=1;i<n;i++)dp[i][0]=i;
//         for(int j=1;j<m;j++)dp[0][j]=j;
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                     dp[i][j] = dp[i - 1][j - 1];
//                 } 
//                 else {
//                     dp[i][j] = 1 + Math.min( dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
//                 }
//             }
//         }

//         return dp[n][m];
//     }
// }