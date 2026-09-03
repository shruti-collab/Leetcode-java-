import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1) return 0;

        int finalState = (1 << n) - 1; // All nodes visited (e.g., for n=4, 1111 in binary = 15)
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        // Initialize BFS by adding all nodes as potential starting points
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            queue.offer(new int[]{i, mask});
            visited[i][mask] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];

                // If all nodes have been visited, return current steps
                if (mask == finalState) {
                    return steps;
                }

                // Visit all adjacent neighbors
                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);

                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true;
                        queue.offer(new int[]{neighbor, nextMask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}