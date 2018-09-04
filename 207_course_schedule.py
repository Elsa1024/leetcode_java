class Solution:
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        graph = [[] for x in range(numCourses)]
        visited = [0 for x in range(numCourses)]
        for e1, e2 in prerequisites:
            graph[e1].append(e2)
        def dfs(e):
            if visited[e] == -1:
                return False
            if visited[e] == 1:
                return True
            visited[e] = -1
            for p in graph[e]:
                if not dfs(p):
                    return False
            visited[e] = 1
            return True
        for e in range(numCourses):
            if not dfs(e):
                return False
        return True
