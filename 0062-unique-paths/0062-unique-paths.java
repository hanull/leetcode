class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return dfs(1, 1, m, n, dp);
    }
    
    private int dfs(int x, int y, int m, int n, int[][] dp) {
        if (x > m || y > n) {
            return 0;
        }
        
        if (x == m && y == n) {
            return 1;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        return dp[x][y] = dfs(x + 1, y, m, n, dp) + dfs(x, y + 1, m, n, dp);
    }
}