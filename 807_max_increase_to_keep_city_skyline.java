class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int size = grid.length;
        int[] colMax = new int[size];
        int[] rowMax = new int[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] > colMax[j])
                    colMax[j] = grid[i][j];
                if (grid[i][j] > rowMax[i]) 
                    rowMax[i] = grid[i][j];
            }
        }
        
        int maxIncrease = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int max = colMax[j] < rowMax[i] ? colMax[j] : rowMax[i];
                maxIncrease += max - grid[i][j];
            }
        }
        
        return maxIncrease;
    }
}
