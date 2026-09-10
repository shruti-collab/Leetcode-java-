class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);

        // Initialize the closest sum with the first three elements
        int res = nums[0] + nums[1] + nums[2];

        // Fix one element at a time
        for (int i = 0; i < nums.length - 2; i++) {

            // Two pointers
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                // Current sum of the triplet
                int sum = nums[i] + nums[l] + nums[r];

                // Update the closest sum if current sum is closer
                if (Math.abs(target - sum) < Math.abs(target - res)) {
                    res = sum;
                }

                // Perfect match found
                if (sum == target) {
                    return sum;
                }

                // Increase the sum
                else if (sum < target) {
                    l++;
                }

                // Decrease the sum
                else {
                    r--;
                }
            }
        }

        // Return the closest sum found
        return res;
    }
}