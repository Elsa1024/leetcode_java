class Solution {
    private void filterO(int x, int y, int row, int col, char[][] board) {
        if (board[x][y] == 'O') {
            board[x][y] = 'Y';
            if (x - 1 > 0)
                filterO(x-1, y, row, col, board);
            if (x + 2 < row)
                filterO(x+1, y, row, col, board);
            if (y - 1 > 0)
                filterO(x, y-1, row, col, board);
            if (y + 2 < col)
                filterO(x, y+1, row, col, board);
        }
    }
    
    public void solve(char[][] board) {
        int row = board.length;
        if (row > 0) {
            int col = board[0].length;
            if (col > 0) {
                for (int i = 0, j = 0; j < col; j++) filterO(i, j, row, col, board);
                for (int i = row - 1, j = 0; j < col; j++) filterO(i, j, row, col, board);
                for (int i = 0, j = 0; i < row; i++) filterO(i, j, row, col, board);
                for (int i = 0, j = col - 1; i < row; i++) filterO(i, j, row, col, board);
                for (int i = 0; i < row; i++)
                    for (int j = 0; j < col; j++) {
                        if (board[i][j] == 'Y')
                            board[i][j] = 'O';
                        else 
                            board[i][j] = 'X';
                }
            }
        }
    }
}
