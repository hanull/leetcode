class Solution { 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        if (candidates[0] > target) {
            return answer;
        }
        
        dfs(0, 0, candidates, target, new ArrayList<>(), answer);
        
        return answer;
    }
    
    private void dfs(int index, int sum, int[] candidates, int target, List<Integer> nums, List<List<Integer>> answer) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            answer.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i=index; i<candidates.length; i++) {
            nums.add(candidates[i]);
            dfs(i, sum + candidates[i], candidates, target, nums, answer);
            nums.remove(nums.size() - 1);
        }
    }
}