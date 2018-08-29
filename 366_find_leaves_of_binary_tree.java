class Solution {
    private int processLeaf(TreeNode root, List<List<Integer>> leaves) {        
        if (root == null)
            return -1;
        
        if (root.left == null && root.right == null) {
            if (leaves.size() == 0) 
                leaves.add(0, new ArrayList<>());
            leaves.get(0).add(root.val);
            return 0;
        }
        
        int left = processLeaf(root.left, leaves), right = processLeaf(root.right, leaves);
        int index = Math.max(left, right) + 1;
        if (index >= leaves.size()) 
            leaves.add(index, new ArrayList<>());
        leaves.get(index).add(root.val);        
        return index;
    }
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();        
        processLeaf(root, leaves);

        return leaves;
    }
}
