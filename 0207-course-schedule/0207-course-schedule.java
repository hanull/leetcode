class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] courses = new List[numCourses];

        for (int[] ints : prerequisites) {
            int target = ints[0];
            int prerequisite = ints[1];
            
            if (courses[prerequisite] == null) {
                courses[prerequisite] = new ArrayList<>();
            }
            courses[prerequisite].add(target);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] finished = new boolean[numCourses];
        for (int i=0; i<numCourses; i++) {
            if (hasCycle(i, visited, finished, courses)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean hasCycle(int num, boolean[] visited, boolean[] finished, List<Integer>[] courses) {
        if (courses[num] == null) {
            return false;
        }
        
        visited[num] = true;
        for (int next : courses[num]) {
            if (!visited[next]) {
                boolean flag = hasCycle(next, visited, finished, courses);
                if (flag) {
                    return true;
                }
            } else if (!finished[next]) {
                return true;
            }
        }
        finished[num] = true;
        
        return false;
    }
}