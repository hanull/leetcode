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
        return makeTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }
    
    private TreeNode makeTree(int preorderStart, int preorderEnd, int[] preorder, int inorderStart, int inorderEnd, int[] inorder) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        
        int parentValue = preorder[preorderStart];
        int inorderParentIndex = getInorderParentIndex(parentValue, inorderStart, inorderEnd, inorder);
        int countOfLeftSubNodes = inorderParentIndex - inorderStart;
        
        TreeNode root = new TreeNode(parentValue);
        root.left = makeTree(preorderStart + 1, preorderStart + countOfLeftSubNodes, preorder, inorderStart, inorderParentIndex - 1, inorder);
        root.right = makeTree(preorderStart + countOfLeftSubNodes + 1, preorderEnd, preorder, inorderParentIndex + 1, inorderEnd, inorder);
        
        return root;
    }
    
    private int getInorderParentIndex(int target, int start, int end, int[] inorder) {
        for (int i=start; i<=end; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        
        return -1;
    }
}