class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        
        if (i == 0) {
            reverse(nums);
            return;
        }
        
        int j = nums.length - 1;
        while (nums[i - 1] >= nums[j]) {
            j--;
        }
        
        swap(nums, i - 1, j);
        
        reorder(nums, i, nums.length - 1);
    }
    
    private void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reorder(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}