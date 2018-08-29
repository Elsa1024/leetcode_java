/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        
        if (isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left))
            return true;
        
        return false;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) 
            return true;
        
        return isMirrorTree(root.left, root.right);
    }
}
