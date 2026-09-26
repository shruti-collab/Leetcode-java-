// class Solution {
//     public int minAbsDifference(int[] nums, int goal) {
//         int n = nums.length;
//         int[] min = {Integer.MAX_VALUE};
//         int[] sum = {0};

//         recur(0, n, goal, nums, sum, min);
//         return min[0];
//     }

//     private void recur(int i, int n, int goal, int[] nums, int[] sum, int[] min){
//         if(i==n){
//             if(min[0]>Math.abs(sum[0]-goal)){
//                 min[0] = Math.abs(sum[0]-goal);
//             }
//             return;
//         }

//         sum[0] += nums[i];
//         recur(i+1, n, goal, nums, sum, min);
//         sum[0] -= nums[i];
//         recur(i+1, n, goal, nums, sum, min);
//     }

// }
//==================================================================================
// class Solution {
//     public int minAbsDifference(int[] nums, int goal) {
//         int n = nums.length;
//         Map<String, Integer> dp = new HashMap<>();        
//         return recur(0, n, 0, goal, nums, dp);
//     }

//     private int recur(int i, int n, int curr, int goal, int[] nums, Map<String, Integer> dp){
//         if(i==n){
//             return Math.abs(curr-goal);
//         }

//         String key = i+"->"+curr;
//         if(dp.containsKey(key)) return dp.get(key);

//         int pick = recur(i+1, n, curr+nums[i], goal, nums, dp);
//         int notp = recur(i+1, n, curr, goal, nums, dp);
//         dp.put(key, Math.min(pick, notp));

//         return dp.get(key);
//     }

// }
//================================================================================

class Solution{
    public int minAbsDifference(int[] nums, int goal){
        int n = nums.length;
        int[] sum1 = new int[n/2];
        int[] sum2 = new int[n-n/2];
        int k = 0;
        for(int i=0;i<n/2;i++){
            sum1[i] = nums[i]; k++;
        }
        for(int i=0;i<sum2.length;i++){
            sum2[i] = nums[k]; k++;
        }
        
        ArrayList<Integer> sub1 = new ArrayList<>();
        ArrayList<Integer> sub2 = new ArrayList<>();

        recur(0, 0, sum1, sub1);
        recur(0, 0, sum2, sub2);

        Collections.sort(sub1);
        Collections.sort(sub2);

        int low = 0, high = sub2.size()-1;
        int ans = Integer.MAX_VALUE;

        while(low<sub1.size() && high>=0){

            int sum = sub1.get(low)+sub2.get(high);
            ans = Math.min(ans, Math.abs(sum-goal));

            if(sum>goal) high--;
            else if(sum<goal) low++;
            else return 0;

        }

        return ans;

    }

    private void recur(int i, int sum, int[] nums, ArrayList<Integer> arr){
        if(i==nums.length){
            arr.add(sum);
            return;
        }
        recur(i+1, sum+nums[i], nums, arr);
        recur(i+1, sum, nums, arr);
    }

}