class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        if(n==1) return 1;
        int count=1;
       Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int commonendpoints= points[0][1];
        
        for(int i=1; i<n; i++){
            int currs=points[i][0];
             int currendpoint=points[i][1];

            if(commonendpoints<currs){
                commonendpoints=currendpoint;
                count++;
            }
        }
        return count;
    }
}