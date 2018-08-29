class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int col = B[0].length;
        int[][] product = new int[A.length][col];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < col; k++) {
                        if (B[j][k] != 0)
                            product[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }        
        return product;
    }
}
