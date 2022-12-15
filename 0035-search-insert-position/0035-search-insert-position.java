class Solution {
    public int searchInsert(int[] nums, int target) {
        int answer = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = (left + right) / 2;
            if (nums[index] >= target) {
                answer = index;
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return answer;
    }
}