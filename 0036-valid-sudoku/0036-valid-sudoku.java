class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] colums = new HashSet[9];
        Set<Integer>[][] box = new HashSet[3][3];
        
        // init
        for (int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            colums[i] = new HashSet<>();
            box[i/3][i%3] = new HashSet<>();
        }
        
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int num = board[i][j];
                    
                    if (!rows[i].contains(num) &&
                       !colums[j].contains(num) &&
                       !box[i/3][j/3].contains(num)) {
                        rows[i].add(num);
                        colums[j].add(num);
                        box[i/3][j/3].add(num);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}