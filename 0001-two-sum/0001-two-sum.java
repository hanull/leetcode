class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        Map<Integer, Integer> container = new HashMap<>();
        
        for (int i=0; i<nums.length; i++) {
            if (container.containsKey(target - nums[i])) {
                answer[0] = container.get(target - nums[i]);
                answer[1] = i;
                break;
            } else {
                container.put(nums[i], i);
            }
        }
        
        return answer;
    }
}