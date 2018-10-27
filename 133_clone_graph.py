# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return None
        node_copy = UndirectedGraphNode(node.label)
        node_dict = {node: node_copy}
        queue = collections.deque([node])
        while queue:
            node = queue.popleft()
            for neighbor in node.neighbors:
                if neighbor not in node_dict:
                    neighbor_copy = UndirectedGraphNode(neighbor.label)
                    node_dict[neighbor] = neighbor_copy
                    node_dict[node].neighbors.append(neighbor_copy)
                    queue.append(neighbor)
                else:
                    node_dict[node].neighbors.append(node_dict[neighbor])
                    
        return node_copy
