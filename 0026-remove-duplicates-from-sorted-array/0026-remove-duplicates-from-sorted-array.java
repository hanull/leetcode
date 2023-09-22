class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int temp = -101;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != temp) {
                nums[count++] = nums[i];
                temp = nums[i];
            }
        }
        return count;
    }
}