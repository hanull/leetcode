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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexes = toMapInorderIndexes(inorder);
        return makeTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder, inorderIndexes);
    }
    
    private Map<Integer, Integer> toMapInorderIndexes(int[] inorder) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i=0; i<inorder.length; i++) {
            indexes.put(inorder[i], i);
        }
        return indexes;
    }
    
    private TreeNode makeTree(int preorderStart, int preorderEnd, int[] preorder, int inorderStart, int inorderEnd, int[] inorder, Map<Integer,Integer> inorderIndexes) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        
        int parentValue = preorder[preorderStart];
        int inorderParentIndex = inorderIndexes.get(parentValue);
        int countOfLeftSubNodes = inorderParentIndex - inorderStart;
        
        TreeNode root = new TreeNode(parentValue);
        root.left = makeTree(preorderStart + 1, preorderStart + countOfLeftSubNodes, preorder, inorderStart, inorderParentIndex - 1, inorder, inorderIndexes);
        root.right = makeTree(preorderStart + countOfLeftSubNodes + 1, preorderEnd, preorder, inorderParentIndex + 1, inorderEnd, inorder, inorderIndexes);
        
        return root;
    }
}