import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        
        // Convert initial 2D board to a 1D string state
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        
        // Predefined directional moves on a flattened 2x3 board (indices 0 through 5)
        // 0 1 2
        // 3 4 5
        int[][] neighbors = {
            {1, 3},       // Index 0 can swap with 1, 3
            {0, 2, 4},    // Index 1 can swap with 0, 2, 4
            {1, 5},       // Index 2 can swap with 1, 5
            {0, 4},       // Index 3 can swap with 0, 4
            {1, 3, 5},    // Index 4 can swap with 1, 3, 5
            {2, 4}        // Index 5 can swap with 2, 4
        };
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start);
        visited.add(start);
        
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return moves;
                }
                
                int zeroIndex = current.indexOf('0');
                
                for (int neighbor : neighbors[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, neighbor);
                    
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}