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
    // dfs
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return root;
        
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        
        return root;
    }
    
    // bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode currentNode = q.poll();
            TreeNode left = currentNode.left;
            
            currentNode.left = currentNode.right;
            currentNode.right = left;
            
            if (currentNode.left != null) q.add(currentNode.left);
            if (currentNode.right != null) q.add(currentNode.right);
        }
        
        return root; 
    }
}