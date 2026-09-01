import java.util.Arrays;

class Solution {

    private long getOps(int x, long t) {
        if ((x & t) == t) return 0;

        long cur = 0;
        for (int i = 30; i >= 0; i--) {
            long tBit = t & (1L << i);
            long xBit = x & (1L << i);

            if (tBit != 0 && xBit == 0) {
                cur |= (1L << i);
                cur |= (t & ((1L << i) - 1));
                return cur - x;
            }
            if (xBit != 0) {
                cur |= (1L << i);
            }
        }
        return cur - x;
    }

    public int maximumAND(int[] nums, int k, int m) {
        long cur = 0;

        for (int i = 30; i >= 0; i--) {
            long t = cur | (1L << i);
            long[] cost = new long[nums.length];

            for (int j = 0; j < nums.length; j++) {
                cost[j] = getOps(nums[j], t);
            }

            Arrays.sort(cost);

            long need = 0;
            for (int j = 0; j < m; j++) {
                need += cost[j];
                if (need > k) break;
            }

            // Update target bit mask if budget k allows transform for at least m elements
            if (need <= k) {
                cur = t;
            }
        }

        return (int) cur;
    }
}