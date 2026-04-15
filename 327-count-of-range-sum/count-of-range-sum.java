class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = 0;

        count += mergeSort(prefix, left, mid, lower, upper);
        count += mergeSort(prefix, mid + 1, right, lower, upper);

        int j = mid + 1;
        int k = mid + 1;
        int t = mid + 1;
        long[] temp = new long[right - left + 1];
        int idx = 0;

        for (int i = left; i <= mid; i++) {
            while (k <= right && prefix[k] - prefix[i] < lower) k++;
            while (j <= right && prefix[j] - prefix[i] <= upper) j++;
            count += j - k;

          
            while (t <= right && prefix[t] < prefix[i]) {
                temp[idx++] = prefix[t++];
            }
            temp[idx++] = prefix[i];
        }

        while (t <= right) {
            temp[idx++] = prefix[t++];
        }

        System.arraycopy(temp, 0, prefix, left, temp.length);
        return count;
    }
}