import java.util.ArrayList;

class Solution {
    private ArrayList<Integer> dp;

    private int helper(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp.get(i) != -1) {
            return dp.get(i);
        }

        int robCurr = nums[i] + helper(nums, i + 2);
        int skipCurr = helper(nums, i + 1);

        int maxVal = Math.max(robCurr, skipCurr);
        dp.set(i, maxVal);
        return maxVal;
    }

    public int rob(int[] nums) {
        dp = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            dp.add(-1);
        }
        return helper(nums, 0);
    }
}