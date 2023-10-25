class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if (flowerbed.length == 1) {
            if (n == 0 || flowerbed[0] == 0 && n == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int i=0; i<flowerbed.length; i++) {
            boolean flag = false;
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flag = true;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    flag = true;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
                    flag = true;
                }
            }
            if (flag) {
                count++;
                flowerbed[i] = 1;
            }
        }
        
        return count >= n;
    }
}