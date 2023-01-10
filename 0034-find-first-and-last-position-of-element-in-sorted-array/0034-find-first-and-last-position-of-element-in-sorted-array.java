class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{-1,-1};
        
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return getPosition(mid, nums);
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
    
    public int[] getPosition(int index, int[] nums) {
        int start = index;
        int end = index;
        int target = nums[index];
        while (start - 1 >= 0 && nums[start - 1] == target) {
            start--;
        }
        while (end + 1 < nums.length && nums[end + 1] == target) {
            end++;
        }
        return new int[]{start, end};
    }
}