class Solution {
    
    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> nodes = new ArrayDeque<>();
        boolean[][] visited = new boolean[image.length][image[0].length];
        nodes.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        int target = image[sr][sc];
        image[sr][sc] = color;
        
        while(!nodes.isEmpty()) {
            int[] node = nodes.poll();
            int cx = node[0];
            int cy = node[1];
            for (int d=0; d<4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || nx >= image.length || ny < 0 || ny >= image[0].length) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (image[nx][ny] != target) {
                    continue;
                }
                visited[nx][ny] = true;
                image[nx][ny] = color;
                nodes.add(new int[]{nx, ny});
            }
        }
        return image;
    }
}