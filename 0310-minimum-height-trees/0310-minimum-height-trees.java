class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        
        List<Integer>[] nodes = new List[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            if (nodes[from] == null) {
                nodes[from] = new ArrayList<>();
            }
            if (nodes[to] == null) {
                nodes[to] = new ArrayList<>();
            }
            
            nodes[from].add(to);
            nodes[to].add(from);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        int[] indegree = new int[n];
        for (int i=0; i<n; i++) {
            if (nodes[i] != null) {
                indegree[i] = nodes[i].size();
            }
            if (indegree[i] == 1) {
                q.add(i);
            }
        }
        
        int leftNodeCount = n;
        while (leftNodeCount > 2)  {
            int size = q.size();
            leftNodeCount -= size;
            
            while (size-- > 0) {
                int node = q.poll();
                for (int nextNode : nodes[node]) {
                    indegree[nextNode]--;
                    
                    if (indegree[nextNode] == 1) {
                        q.add(nextNode);
                    }
                }
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        answer.addAll(q);
        return answer;
    }
}