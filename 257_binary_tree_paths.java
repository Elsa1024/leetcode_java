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
    private void treePaths(TreeNode root, List<String> paths, String beforePath) {
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(beforePath);
            sb.append("->");
            sb.append(root.val);
            String path = sb.toString();
            paths.add(path.substring(2, path.length()));
            return;
        }
        if (root.left != null) {
            treePaths(root.left, paths, beforePath + "->" + root.val);
        }
        if (root.right != null) {
            treePaths(root.right, paths, beforePath + "->" + root.val);
        }
        return;
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null)
            treePaths(root, paths, "");
        return paths;
    }
}
