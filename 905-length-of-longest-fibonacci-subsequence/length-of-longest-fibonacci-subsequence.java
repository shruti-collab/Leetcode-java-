import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        // dp[i][j] stores the length of Fibonacci subsequence ending at indices i and j
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prevVal = arr[j] - arr[i];
                
                // arr[k] + arr[i] = arr[j] requires arr[k] < arr[i], so prevVal < arr[i]
                if (prevVal < arr[i] && indexMap.containsKey(prevVal)) {
                    int k = indexMap.get(prevVal);
                    // If a valid previous element exists, extend the sequence; otherwise start a sequence of length 3
                    dp[i][j] = dp[k][i] > 0 ? dp[k][i] + 1 : 3;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}