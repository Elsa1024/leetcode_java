class Solution {
    public int uniquePaths(int m, int n) {
    if (m == 0 || n == 0)
            return 0;
        
        if (m == 1)
            return 1;
        
        if (n == 1)
            return 1;
        
        int right = m - 1, down = n - 1, min = Math.min(m - 1, n - 1);
        int sum = right + down, counter = 0, i = min;
        double numOfPaths = 1.0;
        while (counter++ < min) 
            numOfPaths = numOfPaths * (sum--) / (i--);
    
        
        return (int)Math.round(numOfPaths);
    }
}
