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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode sub0 = null, sub1 = null, preRoot = null, curRoot = root;
        while (curRoot != null) {
            if (curRoot.val <= V) {
                TreeNode partialSub0 = null, partialSub1 = null;
                if (curRoot.right != null) {
                    TreeNode[] partialResult = splitBST(curRoot.right, V);
                    partialSub0 = partialResult[0];
                    partialSub1 = partialResult[1];
                }
                if (preRoot == null)
                    sub1 = partialSub1;
                else {
                    sub1 = root;
                    preRoot.left = partialSub1;
                }
                
                curRoot.right = partialSub0;
                sub0 = curRoot;
                break;
            }
            
            preRoot = curRoot;
            curRoot = curRoot.left;
        }
        
        if (sub0 == null && sub1 == null && root != null)
            sub1 = root;
        return new TreeNode[]{sub0, sub1};
    }
}
