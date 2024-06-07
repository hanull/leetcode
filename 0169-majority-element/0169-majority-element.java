class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int answer = nums[0];
        int target = nums[0];
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            } else {
                count = 1;
                target = num;
            }
            
            if (count >= nums.length / 2 && count > max) {
                answer = num;
                max = count;
            }
        }
        
        return answer;
    }
}