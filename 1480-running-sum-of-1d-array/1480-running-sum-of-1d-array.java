class Solution {
    public int[] runningSum(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                answer[i] = nums[i];
                continue;
            }
            answer[i] = answer[i - 1] + nums[i];
        }
        return answer;
    }
}