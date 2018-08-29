class Solution {
    boolean isPotentialSuccessor = false;
    TreeNode successor = null;

    public void inorderTraverse(TreeNode root, TreeNode p) {
        if (root == null)
            return;
                
        inorderTraverse(root.left, p);
        if (successor != null)
            return;

        if (isPotentialSuccessor) {
            successor = root;
            return;
        }
        
        if (root == p)
            isPotentialSuccessor = true;
            
        inorderTraverse(root.right, p);        
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderTraverse(root, p);
        return successor;
    }
}
