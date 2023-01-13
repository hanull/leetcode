class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtracking(0, new ArrayList<>(), answer, nums);
        return answer;
    }
    
    public void backtracking(int start, List<Integer> tempNums, List<List<Integer>> answer, int[] nums) {
        if (start > nums.length) {
            return;
        }
        answer.add(new ArrayList<>(tempNums));
        
        for (int i=start; i<nums.length; i++) {
            tempNums.add(nums[i]);
            backtracking(i+1, tempNums, answer, nums);
            tempNums.remove(tempNums.size() - 1);
        }
    }
}