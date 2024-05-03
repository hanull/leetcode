class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        
        int temp = 1;
        for (int i=1; i<len; i++) {
            temp *= nums[i - 1];
            answer[i] += temp;
        }
        
        answer[0] = 1;
        temp = 1;
        for (int i=len-2; i>=0; i--) {
            temp *= nums[i + 1];
            answer[i] *= temp;
        }
        
        return answer;
    }
}