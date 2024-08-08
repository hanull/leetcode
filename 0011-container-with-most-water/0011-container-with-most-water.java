class Solution {
    public int maxArea(int[] height) {
        int answer = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int x = end - start;
            int y = Math.min(height[start], height[end]);
            answer = Math.max(answer, x * y);
            
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return answer;
    }
}