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
    private int maxIndex(int[] nums) {
        int maxIndex = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) { 
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }
    
    public TreeNode contructTree(int[] nums) {
        if (nums == null || nums.length == 0) 
            return null;
        
        int maxIndex = maxIndex(nums);
        
        TreeNode root = new TreeNode(nums[maxIndex]);
        
        if (maxIndex >= 0) {
            int[] leftArray = Arrays.copyOfRange(nums, 0, maxIndex);
            root.left = contructTree(leftArray);
        } else {
            root.left = null;
        }
        
        if (nums.length > maxIndex + 1) {
            int[] rightArray = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
            root.right = contructTree(rightArray);
        } else {
            root.right = null;
        }
    
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return contructTree(nums);
    }
}


/*
class Solution {
     private int maxIndex(int[] nums, int l, int r) {
        int maxIndex = l;
        int max = nums[l];
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) { 
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }
    
    public TreeNode contructTree(int[] nums, int l, int r) {
        TreeNode root = null;
        if (l == r) {
            root = new TreeNode(nums[l]);
        } else {
            int maxIndex = maxIndex(nums, l, r);
            root = new TreeNode(nums[maxIndex]);
            if (maxIndex - 1 >= l) {
                root.left = contructTree(nums, l, maxIndex - 1);
            } else {
                root.left = null;
            }
            
            if (r >= maxIndex + 1) {
                root.right = contructTree(nums, maxIndex + 1, r);
            } else {
                root.right = null;
            }
        }
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return contructTree(nums, 0, nums.length - 1);
    }
}
*/

/* faster than the first one */