class Solution {
    public int jump(int[] nums) {
        int maxEndIndex = 0;
        int currentEndIndex = 0;
        int jumpCount = 0;
        for (int i=0; i<nums.length - 1; i++) {
            maxEndIndex = Math.max(maxEndIndex, i + nums[i]);
            
            if (maxEndIndex >= nums.length - 1) {
                jumpCount++;
                break;
            }
            
            // 현재 포인트에서 갈 수 있는 최대 위치까지 온 경우, 다음 점프를 이용해야 함.
            // 따라서 최대 위치를 갱신하고, 점프 수를 1 증가
            if (currentEndIndex == i) {
               currentEndIndex = maxEndIndex;
                jumpCount++;
            }
        }
        return jumpCount;
    }
}