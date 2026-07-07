import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums); // Sorts the array in ascending order
        return nums[0];    // Returns the first (smallest) element
    }
}