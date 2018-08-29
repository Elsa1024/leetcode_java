class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int ROW, COL;
    
    public int numIslands(char[][] grid) {
        int counter = 0;
        ROW = grid.length;
        if (ROW == 0)
            return counter;
        COL = grid[0].length;
        
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (grid[i][j] == '1') {
                    extendIsland(grid, i, j);
                    counter++;
                }
            }
        }
        
        return counter;
    }
    
    public void extendIsland(char[][] grid, int x, int y) {
        int i, j;
        grid[x][y] = '\0';
        for (int[] dir : DIRECTIONS) {
            i = dir[0] + x;
            j = dir[1] + y;
            if (i >= 0 && i < ROW && j >= 0 && j < COL && grid[i][j] == '1') {
                extendIsland(grid, i, j);
                grid[i][j] = '\0';
            }
        }
        return;
    }
}
