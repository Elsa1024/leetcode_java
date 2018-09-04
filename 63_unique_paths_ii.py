class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """
        x, y = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0 for i in range(y)] for j in range(x)]
        dp[0][0] = 1 if obstacleGrid[0][0] == 0 else 0
        
        
        for i in range(x):
            for j in range(y):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                else:
                    if i > 0:
                        dp[i][j] += dp[i-1][j]
                    if j > 0:
                        dp[i][j] += dp[i][j-1]
        
        return dp[x-1][y-1]
