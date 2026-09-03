class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int natural = 0;
        int swapped = 1;
        
        for (int i = 1; i < n; i++) {
            int nextNatural = Integer.MAX_VALUE;
            int nextSwapped = Integer.MAX_VALUE;
            
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                nextNatural = Math.min(nextNatural, natural);
                nextSwapped = Math.min(nextSwapped, swapped + 1);
            }
            
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                nextNatural = Math.min(nextNatural, swapped);
                nextSwapped = Math.min(nextSwapped, natural + 1);
            }
            
            natural = nextNatural;
            swapped = nextSwapped;
        }
        
        return Math.min(natural, swapped);
    }
}