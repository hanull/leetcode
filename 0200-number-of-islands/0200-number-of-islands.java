class Solution {
    
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    
    public int numIslands(char[][] grid) {
        int answer = 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    move(i, j, visited, grid, n, m);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void move(int x, int y, boolean[][] visited, char[][] grid, int n, int m) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int d=0; d<4; d++) {
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (grid[nx][ny] == '0') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}