class Solution {
    public int search(int[] nums, int target) {
        int index = getPivotIndex(nums);
        int answer = searchTarget(nums, target, 0, index - 1);
        if (answer > -1) {
            return answer;
        }
        
        return searchTarget(nums, target, index, nums.length - 1);
    }
    
    private int getPivotIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            }
            if (nums[0] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return 0;
    }
    
    private int searchTarget(int[] nums, int target, int startIndex, int lastIndex) {
        int left = startIndex;
        int right = lastIndex;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}