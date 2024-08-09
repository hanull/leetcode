class Solution {
    
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(0, i, j, board, word, new boolean[board.length][board[0].length])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean search(int index, int x, int y, char[][] board, String word, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        
        if (visited[x][y]) {
            return false;
        }
        
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        
        visited[x][y] = true;
        if (search(index + 1, x + 1, y, board, word, visited) ||
            search(index + 1, x, y + 1, board, word, visited) ||
            search(index + 1, x - 1, y, board, word, visited) ||
            search(index + 1, x, y - 1, board, word, visited)) {
            return true;
        }
        visited[x][y] = false;
        
        return false;
    }
}