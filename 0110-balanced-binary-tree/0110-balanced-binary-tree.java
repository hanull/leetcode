/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
        
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftHeight = dfs(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = dfs(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        
        int balanced = Math.abs(leftHeight - rightHeight);
        if (balanced > 1) {
            return -1;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}