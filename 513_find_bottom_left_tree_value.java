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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        TreeNode treeNode = null;
        while (!treeQueue.isEmpty()) {
            treeNode = treeQueue.poll();
            if (treeNode.right != null)
                treeQueue.add(treeNode.right);
            if (treeNode.left != null)
                treeQueue.add(treeNode.left);
        }
        return treeNode.val;
    }
}
