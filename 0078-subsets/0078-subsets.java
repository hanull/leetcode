class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        dfs(0, new boolean[nums.length], nums, answer);
        
        return answer;
    }
    
    private void dfs(int index, boolean[] used, int[] nums, List<List<Integer>> answer) {
        if (index == nums.length) {
            answer.add(getSubset(nums, used));
            return;
        }
        
        used[index] = true;
        dfs(index + 1, used, nums, answer);
        used[index] = false;
        dfs(index + 1, used, nums, answer);
    }
    
    private List<Integer> getSubset(int[] nums, boolean[] used) {
        List<Integer> subset = new ArrayList<>();
        for (int i=0; i<used.length; i++) {
            if (used[i]) {
                subset.add(nums[i]);
            }
        }
        return subset;
    }
}