class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Using boolean arrays to keep track of rows and columns that contain 0
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        // Step 1: Find all the rows and columns that need to be zeroed out
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        // Step 2: Set matrix element to 0 if its row or column is marked
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}