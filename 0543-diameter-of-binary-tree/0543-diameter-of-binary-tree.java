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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int[] maxDiameter = {0};
        getMaxLength(root, maxDiameter);
        
        return maxDiameter[0];
    }
    
    public int getMaxLength(TreeNode node, int[] maxDiameter) {
        // 최대 깊이 구하기
        int leftLength = node.left == null ? 0 : getMaxLength(node.left, maxDiameter);
        int rightLength = node.right == null ? 0 : getMaxLength(node.right, maxDiameter);
        
        // 최대 지름 길이 갱신하기
        maxDiameter[0] = Math.max(maxDiameter[0], leftLength + rightLength);
        
        // 현재 노드를 기준으로 왼쪽, 오른쪽 최대 길이 + 1(추가된 현재 노드) 반환하기
        return Math.max(leftLength, rightLength) + 1;
    }
}