class Solution:
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        x, y = len(grid), len(grid[0])
        dp = copy.deepcopy(grid)
        for i in range(x):
            for j in range(y):
                if i > 0 and j > 0:
                    dp[i][j] += min(dp[i-1][j], dp[i][j-1])
                elif i > 0 and j == 0:
                    dp[i][j] += dp[i-1][j]
                elif i == 0 and j > 0:
                    dp[i][j] += dp[i][j-1]
        return dp[-1][-1]
