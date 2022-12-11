class Solution {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                sum[i] = nums[i];
                continue;
            }
            sum[i] = sum[i-1] + nums[i];
        }

        int answer = -1;
        int total = sum[sum.length - 1];
        for (int i=0; i<sum.length; i++) {
            if (sum[i] - nums[i] == total - sum[i]) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}