class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(0, nums, new ArrayList<>(), answer);
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
}