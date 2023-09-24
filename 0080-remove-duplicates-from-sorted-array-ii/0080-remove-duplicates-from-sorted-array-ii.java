class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 1;
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
                if (count >= 3) {
                    continue;
                }
            } else {
                count = 1;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}