class Solution {
    public boolean isValidSudoku(char[][] board) {
      for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.')
                    continue;

                char num = board[r][c];

                // Check row
                for (int i = 0; i < 9; i++) {
                    if (i != c && board[r][i] == num)
                        return false;
                }

                // Check column
                for (int i = 0; i < 9; i++) {
                    if (i != r && board[i][c] == num)
                        return false;
                }

                // Check 3x3 box
                int sr = 3 * (r / 3);
                int sc = 3 * (c / 3);

                for (int i = sr; i < sr + 3; i++) {
                    for (int j = sc; j < sc + 3; j++) {
                        if ((i != r || j != c) && board[i][j] == num)
                            return false;
                    }
                }
            }
        }

        return true;    
    }
}
