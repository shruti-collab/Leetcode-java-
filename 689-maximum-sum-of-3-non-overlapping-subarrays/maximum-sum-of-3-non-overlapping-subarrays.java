class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        // 1. Calculate the sum of all contiguous subarrays of length k
        int m = n - k + 1;
        int[] kSums = new int[m];
        int currentSum = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += nums[i];
            if (i >= k) {
                currentSum -= nums[i - k];
            }
            if (i >= k - 1) {
                kSums[i - k + 1] = currentSum;
            }
        }
        
        // 2. left[i] stores the starting index of the maximum subarray sum in kSums[0...i]
        int[] left = new int[m];
        int bestLeft = 0;
        for (int i = 0; i < m; i++) {
            if (kSums[i] > kSums[bestLeft]) {
                bestLeft = i;
            }
            left[i] = bestLeft;
        }
        
        // 3. right[i] stores the starting index of the maximum subarray sum in kSums[i...m-1]
        // Strictly use '>' to maintain lexicographically smallest order for ties
        int[] right = new int[m];
        int bestRight = m - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (kSums[i] >= kSums[bestRight]) {
                bestRight = i;
            }
            right[i] = bestRight;
        }
        
        // 4. Iterate over the middle interval starting index `j`
        int[] result = new int[]{-1, -1, -1};
        int maxSum = 0;
        
        for (int j = k; j < m - k; j++) {
            int l = left[j - k];
            int r = right[j + k];
            int total = kSums[l] + kSums[j] + kSums[r];
            
            if (total > maxSum) {
                maxSum = total;
                result[0] = l;
                result[1] = j;
                result[2] = r;
            }
        }
        
        return result;
    }
}