class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int rh = height[right];
            int lh = height[left];
            answer = Math.max(answer, (right - left) * Math.min(rh, lh));
            if (rh < lh) {
                right--;
            } else {
                left++;
            }
        }
        return answer;
    }
}