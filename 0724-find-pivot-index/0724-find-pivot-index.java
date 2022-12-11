class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }

        int answer = -1;
        int leftSum = 0;
        for (int i=0; i<nums.length; i++) {
            leftSum += nums[i];
            if (leftSum - nums[i] == sum - leftSum) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}