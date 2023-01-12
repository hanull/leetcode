class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        // backtracking(0, nums, new ArrayList<>(), answer); 백트래킹으로 풀이
        
        Arrays.sort(nums);
        do {
            answer.add(getNums(nums));
        } while(isNextPermute(nums));
        
        return answer;
    }
    
    public void backtracking(int count, int[] nums, List<Integer> tempNums, List<List<Integer>> answer) {
        if (count == nums.length) {
            answer.add(new ArrayList<>(tempNums));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (tempNums.contains(nums[i])) continue;
            tempNums.add(nums[i]);
            count++;
            backtracking(count, nums, tempNums, answer);
            tempNums.remove(tempNums.size() - 1);
            count--;
        }
    }
    
    public boolean isNextPermute(int[] nums) {
        int i=nums.length-1;
        while (i>0 && nums[i-1] >= nums[i]) i--;
        
        if (i<=0) return false;
        
        int j=nums.length-1;
        while (nums[j] <= nums[i-1]) j--;
        
        swap(i-1,j,nums);
        
        j=nums.length-1;
        while(i<j) swap(i++,j--,nums);
        return true;
    }
    
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<Integer> getNums(int[] nums) {
        List<Integer> newOrderNums = new ArrayList<>();
        for (int num:nums) {
            newOrderNums.add(num);
        }
        return newOrderNums;
    }
}