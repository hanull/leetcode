class Solution {
    
    private static int count;
    
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        while (true) {
            if (freshOranges == 0) {
                break;
            }
            
            getRottenOranges(q, visited, grid, n, m);
            if (q.isEmpty()) {
                answer = -1;
                break;
            }
            
            int spreadCount = spread(q, visited, grid, n, m);
            freshOranges -= spreadCount;
            
            answer++;
        }
        
        return answer;
    }
    
    private Queue<int[]> getRottenOranges(Queue<int[]> q, boolean[][] visited, int[][] grid, int n, int m) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] ==2 && !visited[i][j]) {
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        
        return q;
    }
    
    private int spread(Queue<int[]> q, boolean[][] visited, int[][] grid, int n, int m) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        int size = q.size();
        int count = 0;
        while (size-- > 0) {
            int[] node = q.poll();
            for (int d=0; d<4; d++) {
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (grid[nx][ny] != 1) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                count++;
                grid[nx][ny] = 2;
                q.add(new int[]{nx, ny});
            }
        }
        
        return count;
    }
}