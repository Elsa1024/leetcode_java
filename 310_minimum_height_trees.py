class Solution:
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1:
            return [0]
        
        counter, nodes = n, [set() for _ in range(n)]
        for [v1, v2] in edges:
            nodes[v1].add(v2)
            nodes[v2].add(v1)
        leaves = [_ for _ in range(n) if len(nodes[_]) == 1]
        while counter > 2:
            counter -= len(leaves)
            new_leaves = []
            for leaf in leaves:
                next_leaf = nodes[leaf].pop()
                nodes[next_leaf].remove(leaf)
                if len(nodes[next_leaf]) == 1:
                    new_leaves.append(next_leaf)
            leaves = new_leaves

        return leaves
            
