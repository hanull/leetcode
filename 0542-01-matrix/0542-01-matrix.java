class Solution {
    
    static class Node {
        int x, y, dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[][] updateMatrix(int[][] mat) {
        int[][] answer = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> {
            return o1.dist - o2.dist;
        });
        
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    nodes.add(new Node(i, j, 0));
                }
            }
        }
        
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int cx = node.x;
            int cy = node.y;
            int dist = node.dist;
            for (int d=0; d<4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (nx < 0 || nx >= mat.length || ny < 0 || ny >= mat[0].length) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                nodes.add(new Node(nx, ny, dist + 1));
                if (mat[nx][ny] == 1) {
                    answer[nx][ny] = dist + 1;
                }
            }
        }
        return answer;
    }
}