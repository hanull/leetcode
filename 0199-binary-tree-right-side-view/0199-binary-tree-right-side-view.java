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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            int count = nodes.size();
            
            while (count > 0) {
                TreeNode node = nodes.poll();
                
                // 현재 뎁스의 노드들 중 마지막 노드
                // 즉, 맨 오른쪽의 노드
                if (count == 1) {
                    answer.add(node.val);
                }
                
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                
                count--;
            }
        }
        return answer;
    }
}