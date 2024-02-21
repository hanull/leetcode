/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        Node[] answer = new Node[101];
        Node newNode = new Node(node.val);
        dfs(node, answer, newNode);
        return newNode;
    }
    
    private void dfs(Node node, Node[] answer, Node copy) {
        answer[node.val] = copy;
        
        for (Node neighbor : node.neighbors) {
            if (answer[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                copy.neighbors.add(newNode);
                dfs(neighbor, answer, newNode);
            } else {
                copy.neighbors.add(answer[neighbor.val]);
            }
        }
    }
}