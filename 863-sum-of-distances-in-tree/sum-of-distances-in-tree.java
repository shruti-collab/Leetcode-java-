class Solution {
    int[] ans;
    int[] count;
    java.util.List<java.util.List<Integer>> graph;
    int n;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        ans = new int[n];
        count = new int[n];
        graph = new java.util.ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            graph.add(new java.util.ArrayList<>());
        }
        
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        dfs1(0, -1);
        dfs2(0, -1);
        
        return ans;
    }

    private void dfs1(int node, int parent) {
        count[node] = 1;
        for (int child : graph.get(node)) {
            if (child != parent) {
                dfs1(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph.get(node)) {
            if (child != parent) {
                ans[child] = ans[node] - count[child] + n - count[child];
                dfs2(child, node);
            }
        }
    }
}