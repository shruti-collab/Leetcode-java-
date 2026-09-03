import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Map stores remainder and its earliest index
        Map<Integer, Integer> remainderMap = new HashMap<>();
        // Base case: remainder 0 at index -1 handles subarrays starting from index 0
        remainderMap.put(0, -1);
        
        int cumulativeSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            cumulativeSum += nums[i];
            int remainder = cumulativeSum % k;
            
            if (remainderMap.containsKey(remainder)) {
                // Check if the subarray length is at least 2
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                // Only store the first occurrence of each remainder to maximize subarray length
                remainderMap.put(remainder, i);
            }
        }
        
        return false;
    }
}