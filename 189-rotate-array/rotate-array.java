class Solution {

public void reverseArray(int[] arr, int i, int j) {
     while(i<j){
        int temp= arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
        i++;
        j--;
    }
}
        
    
    public void rotate(int[]nums, int k ){
        int n=nums.length;
        k=k%n;
        reverseArray(nums,0,n-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,n-1);

    }

    
}

