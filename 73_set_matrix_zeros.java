class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet();
        Set<Integer> zeroCols = new HashSet();

        int row = matrix.length;
        if (row == 0)
            return;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        
        for (Integer zeroRow : zeroRows) {
            int rowIndex = zeroRow.intValue();
            for (int k = 0; k < col; k++) 
                matrix[rowIndex][k] = 0;
        }
        
        for (Integer zeroCol : zeroCols) {
            int colIndex = zeroCol.intValue();
            for (int m = 0; m < row; m++)
                matrix[m][colIndex] = 0;
        }
        
        return;
    }
}
// passed but slow
