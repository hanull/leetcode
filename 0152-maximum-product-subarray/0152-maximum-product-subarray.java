class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int answer = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            int temp = max;
            
            max = Math.max(Math.max(max * num, min * num), num);
            min = Math.min(Math.min(temp * num, min * num), num);
            
            if (max > answer) {
                answer = max;
            }
        }
        
        return answer;
    }
}