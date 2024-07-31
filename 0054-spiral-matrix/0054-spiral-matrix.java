class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();       
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0;
        int y = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];
        int direction = 0;
        int moveCount = 0;
        
        while (moveCount < n * m) {
            if (!isRange(x, y, n, m) || visited[x][y]) {
                x -= dx[direction];
                y -= dy[direction];
                direction = turn(direction);
                x += dx[direction];
                y += dy[direction];
                continue;
            }
            
            moveCount++;
            visited[x][y] = true;
            answer.add(matrix[x][y]);
            x += dx[direction];
            y += dy[direction];
        }
        
        return answer;
    }
    
    private boolean isRange(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    
    private int turn(int direction) {
        if (direction == 3) {
            return 0;
        }
        return direction + 1;
    }
}