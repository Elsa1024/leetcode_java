class Solution:
    directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    
    def dfs(self, matrix, visited, i, j, row, col):
        if visited[i][j]:
            return
        visited[i][j] = True
        for direction in self.directions:
            x, y = i + direction[0], j + direction[1]
            if 0 <= x < row and 0 <= y < col and matrix[i][j] <= matrix[x][y]:
                self.dfs(matrix, visited, x, y, row, col)
    
    def pacificAtlantic(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix or not matrix[0]:
            return []
        row, col = len(matrix), len(matrix[0])
        p_visited = [[False for _ in range(col)] for _ in range(row)]
        a_visited = [[False for _ in range(col)] for _ in range(row)]
        ans = []
        
        for i in range(row):
            self.dfs(matrix, p_visited, i, 0, row, col)
            self.dfs(matrix, a_visited, i, col-1, row, col)
        for i in range(col):
            self.dfs(matrix, p_visited, 0, i, row, col)
            self.dfs(matrix, a_visited, row-1, i, row, col)
        
        for i in range(row):
            for j in range(col):
                if p_visited[i][j] and a_visited[i][j]:
                    ans.append([i, j])
        
        return ans
