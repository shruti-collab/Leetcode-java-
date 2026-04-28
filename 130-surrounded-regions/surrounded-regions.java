// class Solution {
//     public void solve(char[][] board) {
//          first we will find LL the 0 on the boundary and also allitsa neghibouring 0 and place them makred in the visited list and after all the boudary 0 are marked, we'll move to the part where we will find all the other 0 except bluondary if found check the visited list and if not visited then we will replce it with x and print the no of replcement dine only those will be replced wh are not aourrouned by al the four side and else0 will remain same and then we will return the a;; grid 
        
//     }
// }
class Solution {
    public void solve(char[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        
        // Step 1: DFS from borders
        for (int row = 0; row < rowLength; row++) {
            dfs(board, row, 0);
            dfs(board, row, colLength - 1);
        }

        for (int col = 0; col < colLength; col++) {
            dfs(board, 0, col);
            dfs(board, rowLength - 1, col);
        }

        // Step 2: Flip
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'E') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'E';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}