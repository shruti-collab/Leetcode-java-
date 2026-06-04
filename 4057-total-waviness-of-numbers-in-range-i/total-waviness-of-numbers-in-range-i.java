class Solution {
    //O(n*d)
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int n= num1; n<=num2; n++){
            ans += getWaviness(n);
        }
        return ans;
        
    }
    int getWaviness(int n){
        String s= Integer.toString(n);
        int count=0;
        char arr[] = s.toCharArray(); 
        for(int i=1; i<arr.length-1; i++){
            if(arr[i]>arr[i-1] && arr[i]> arr[i+1] || (arr[i]<arr[i-1]&& arr[i]< arr[i+1]))
                count++;
            
        }
        return count;
        
    }
}