# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, inorder, postorder):
        """
        :type inorder: List[int]
        :type postorder: List[int]
        :rtype: TreeNode
        """
        if not inorder or not postorder:
            return None
        
        root = TreeNode(postorder.pop())
        rootIndex = inorder.index(root.val)
        
        root.right = self.buildTree(inorder[rootIndex+1:], postorder[rootIndex:])
        root.left = self.buildTree(inorder[:rootIndex], postorder[:rootIndex])
        
        return root
