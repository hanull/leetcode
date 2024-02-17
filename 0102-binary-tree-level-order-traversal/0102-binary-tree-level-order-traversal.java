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
    
    static int maxLevel;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> nodes = new HashMap<>();
        dfs(root, nodes, 0);
        
        List<List<Integer>> answer = new ArrayList<>();
        for (int i=0; i<=maxLevel; i++) {
            if (nodes.get(i) != null) {
                answer.add(nodes.get(i));
            }
        }
        
        return answer;
    }
    
    private void dfs(TreeNode root, Map<Integer, List<Integer>> nodes, int level) {
        if (root == null) {
            return;
        }
        
        if (nodes.get(level) == null) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(root.val);
            nodes.put(level, tmp);
        } else {
            nodes.get(level).add(root.val);
        }
        
        maxLevel = Math.max(maxLevel, level);
        
        dfs(root.left, nodes, level + 1);
        dfs(root.right, nodes, level + 1);
    }
}