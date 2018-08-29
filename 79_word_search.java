class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int ROW, COL;
    
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        if (word.length() > ROW*COL) return false;
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 1))
                    return true;

        return false;
    }
    
    public boolean dfs(char[][] board, int x, int y, String word, int index) {
        if (index >= word.length())
            return true;
        
        char temp = board[x][y];
        board[x][y] = '\0';

        int nextX, nextY;
        for (int[] dir : DIRECTIONS) {
            nextX = x + dir[0];
            nextY = y + dir[1];
            if (nextX < 0 || nextX >= ROW || nextY < 0 || nextY >= COL) continue;
            if (board[nextX][nextY] == word.charAt(index) && dfs(board, nextX, nextY, word, index+1)) return true;
        }
        board[x][y] = temp;
        return false;
    }
}
