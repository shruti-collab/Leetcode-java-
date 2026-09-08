class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n+1];
        int suffix[]=new int [n];
        prefix[0]=0;
        suffix[n-1]=nums[n-1];
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        for(int i=n-2;i>=0;i--){
            suffix[i]=suffix[i+1]+nums[i];
        }
        for(int i=0;i<n;i++){
            int leftsum=prefix[i];
            int rightsum=suffix[i]-nums[i];
            if(leftsum==rightsum) return i;
        }
        return -1;
    }
}