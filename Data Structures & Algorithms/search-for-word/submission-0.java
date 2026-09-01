class Solution {
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int index) {

        // All characters matched
        if (index == word.length()) {
            return true;
        }

        // Out of bounds
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return false;
        }

        // Character does not match
        if (board[r][c] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        char temp = board[r][c];
        board[r][c] = '#';

        // Move in 4 directions
        boolean found =
                dfs(board, word, r - 1, c, index + 1) || // up
                dfs(board, word, r + 1, c, index + 1) || // down
                dfs(board, word, r, c - 1, index + 1) || // left
                dfs(board, word, r, c + 1, index + 1);   // right

        // Backtrack
        board[r][c] = temp;

        return found;
    }
}