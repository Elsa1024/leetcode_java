class Solution {
    public void traversal(List<Integer> nodeList, TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            traversal(nodeList, root.left);
        nodeList.add(root.val);
        if (root.right != null)
            traversal(nodeList, root.right);
        return;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        traversal(nodeList, root);
        return nodeList;
    }
}

/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodeList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            nodeList.add(curr.val);
            curr = curr.right;
        }
        return nodeList;
    }
}
*/
// iteration & stack, which is also a good method
