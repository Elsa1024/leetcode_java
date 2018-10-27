"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):    
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        ans = []
        if not root:
            return ans
        nodes = collections.deque([(root, 1)])
        while nodes:
            element = nodes.popleft()
            node = element[0]
            level = element[1]
            while level > len(ans):
                ans.append([])
            ans[level-1].append(node.val)
            if len(node.children):
                for child in node.children:
                    nodes.append((child, level+1))
            
        return ans
