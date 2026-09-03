class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int i = 1;

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand leftward down the slope
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand rightward down the slope
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate current mountain length
                int currentLen = right - left + 1;
                maxLen = Math.max(maxLen, currentLen);

                // Move index to the end of the current mountain
                i = right;
            } else {
                i++;
            }
        }

        return maxLen;
    }
}