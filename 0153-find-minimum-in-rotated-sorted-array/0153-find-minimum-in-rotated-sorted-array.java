class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[0] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return nums[0];
    }
}