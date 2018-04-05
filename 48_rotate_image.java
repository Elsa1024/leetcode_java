class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if (length > 1) {
            int number = length * length;
            for (int i = 0; i < length / 2; i++) {
                for (int j = i; j < length - 1 - i; j++) {
                    int counter = 0, x = i, y = j, temp = matrix[i][j];
                    while (counter < 4) {
                        int nextX = y;
                        int nextY = length - 1 - x;
                        int nextTemp = matrix[nextX][nextY];
                        matrix[nextX][nextY] = temp;
                        temp = nextTemp;
                        x = nextX;
                        y = nextY;
                        counter++;
                    }
                }
            }
        }
    }
}
