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
    private void traversal(TreeNode root, List<Integer> tree) {
        if (root == null) {
            tree.add(null);
            return;
        }
        tree.add(root.val);
        if (root.left != null)
            traversal(root.left, tree);
        if (root.right != null)
            traversal(root.right, tree);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> tree = new ArrayList<>();
        if (root != null)
            traversal(root, tree);
        return tree;
    }
}
