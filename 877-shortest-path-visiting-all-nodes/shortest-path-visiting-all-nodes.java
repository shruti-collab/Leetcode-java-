import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {

        int n=graph.length;
        int finalMask=(1<<n)-1;

        Queue<int[]> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][1<<n];

        for(int i=0;i<n;i++){
            q.add(new int[]{i,1<<i,0});
            vis[i][1<<i]=true;
        }

        while(!q.isEmpty()){

            int[] cur=q.poll();
            int node=cur[0], mask=cur[1], dist=cur[2];

            if(mask==finalMask) return dist;

            for(int nei:graph[node]){

                int nextMask=mask | (1<<nei);

                if(!vis[nei][nextMask]){
                    vis[nei][nextMask]=true;
                    q.add(new int[]{nei,nextMask,dist+1});
                }
            }
        }
        return -1;
    }
}
