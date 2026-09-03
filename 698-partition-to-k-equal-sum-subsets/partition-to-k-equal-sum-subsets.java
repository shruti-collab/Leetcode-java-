import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // If total sum is not divisible by k, we can't partition evenly
        if (sum % k != 0) {
            return false;
        }

        int target = sum / k;

        // Sort array and reverse order to process larger elements first (prunes search tree faster)
        Arrays.sort(nums);
        int n = nums.length;

        // If the largest element is greater than target, partition is impossible
        if (nums[n - 1] > target) {
            return false;
        }

        boolean[] visited = new boolean[n];
        return backtrack(nums, visited, 0, k, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int startIndex, int k, int currentSum, int target) {
        // All k subsets successfully formed
        if (k == 0) {
            return true;
        }

        // Current subset is complete; move to filling the next subset
        if (currentSum == target) {
            return backtrack(nums, visited, 0, k - 1, 0, target);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i] || currentSum + nums[i] > target) {
                continue;
            }

            // Pruning: skip duplicate elements at the same recursion depth
            if (i > startIndex && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            if (backtrack(nums, visited, i + 1, k, currentSum + nums[i], target)) {
                return true;
            }
            visited[i] = false;

            // Pruning: if the first element chosen for a subset fails, no other combination will work
            if (currentSum == 0) {
                return false;
            }
        }

        return false;
    }
}