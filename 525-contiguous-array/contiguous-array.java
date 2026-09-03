import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of each running sum count
        Map<Integer, Integer> map = new HashMap<>();
        // Base case: count 0 occurs before the array starts (index -1)
        map.put(0, -1);
        
        int maxLength = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Treat 1 as +1 and 0 as -1
            count += (nums[i] == 1) ? 1 : -1;
            
            if (map.containsKey(count)) {
                // Same count means equal number of 0s and 1s in the subarray between indices
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                // Store only the first occurrence to maximize subarray length
                map.put(count, i);
            }
        }
        
        return maxLength;
    }
}