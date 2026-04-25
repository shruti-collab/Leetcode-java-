class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
       
        List<List<Integer>> al=new ArrayList<>();
        int end=intervals[0][1];
        int start=intervals[0][0];
        for(int i=1;i<n;i++){
            List<Integer> li=new ArrayList<>();
            if(end>=intervals[i][0]){
                li.add(start);
                end=Math.max(end,intervals[i][1]);
            }
            else{
                li.add(start);
                li.add(end);
                start=intervals[i][0];
                end=intervals[i][1];
                al.add(li);
            }
            


        }
        List<Integer> li=new ArrayList<>();
        li.add(start);
        li.add(end);
        al.add(li);
        
        
        // System.out.print(al);
        int[][] arr=new int[al.size()][2];
        for(int i=0;i<al.size();i++){
            arr[i][0]=al.get(i).get(0);
            arr[i][1]=al.get(i).get(1);
        }
        return arr;

        
        
       
    }
}