class Solution {
    // sorting
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    // Moore voting algorithm
    public int majorityElement2(int[] nums) {
        int count = 1;
        int major = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }
}