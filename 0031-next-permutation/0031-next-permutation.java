class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) i--;
        
        if (i < 0) {
            reverse(0, nums.length-1, nums);
            return;
        }
        
        int j = nums.length - 1;
        while (j > i && nums[j] <= nums[i]) j--;
        
        swap(i, j, nums);
        
        reverse(i + 1, nums.length - 1, nums);
    }
    
    public void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}