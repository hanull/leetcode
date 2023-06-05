class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        
        int a = coordinates[1][0] - coordinates[0][0];
        int b = coordinates[1][1] - coordinates[0][1];
        for (int i=2; i<coordinates.length; i++) {
            if (a * (coordinates[i][1] - coordinates[0][1]) != b * (coordinates[i][0] - coordinates[0][0])) {
                return false;
            }
        }
        return true;
    }
}