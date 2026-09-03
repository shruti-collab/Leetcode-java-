class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Find the maximum value in nums to determine the size of our frequency sum array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Pre-aggregate the total points you can earn from each number
        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // House Robber logic:
        // You cannot take points from adjacent values (i and i - 1 or i + 1)
        int skip = 0; // max points if we don't pick current number
        int take = 0; // max points if we pick current number

        for (int i = 0; i <= maxVal; i++) {
            int currentTake = skip + points[i];
            int currentSkip = Math.max(skip, take);

            take = currentTake;
            skip = currentSkip;
        }

        return Math.max(skip, take);
    }
}