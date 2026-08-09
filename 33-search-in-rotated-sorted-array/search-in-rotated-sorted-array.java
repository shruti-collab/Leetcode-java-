class Solution {
    public int search(int[] nums, int target) {
        // int n= nums.length;
        // for(int i=0; i<n;i++){
        //     if (nums[i]== target){
        //         return i;
        //     }

        // }
        // return -1;
        int low=0, high= nums.length-1;
        while(low<= high){
            int mid= low+ (high-low)/2;
            if(nums[mid]== target){
                return mid;
            }
            if(nums[low]<= nums[mid]){
                if(nums[low]<=target && target<nums[mid]){
                    high = mid-1;
                } else{
                    low= mid+1;
                }               
            }else{
                if(nums[mid]<target && target<=nums[high]){
                    low=mid+1;
                }else{
                    high= mid-1;
                }
            }
            

        }
        return  -1;
        
    }
}