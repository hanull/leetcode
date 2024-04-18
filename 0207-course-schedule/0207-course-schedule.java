class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] nodes = new List[numCourses];
        for (int i=0; i<numCourses; i++) {
            nodes[i] = new ArrayList<>();
        }
        
        int[] indegrees = new int[numCourses];
        for (int[] ints : prerequisites) {
            int to = ints[0];
            int from = ints[1];
            
            indegrees[to]++;
            nodes[from].add(to);
        }
        
        return isPossibleToSort(indegrees, nodes, numCourses);
    }
    
    private boolean isPossibleToSort(int[] indegrees, List<Integer>[] nodes, int numCourses) {
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i=0; i<numCourses; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }
        
        Queue<Integer> answer = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            answer.add(node);
            
            for (int nextNode : nodes[node]) {
                indegrees[nextNode]--;
                
                if (indegrees[nextNode] == 0) {
                    q.add(nextNode);
                }
            }
        }
        
        return answer.size() == numCourses;
    }
}