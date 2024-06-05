class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        Arrays.sort(nums);
        
        dfs(0, new boolean[nums.length], nums, new ArrayList<>(), answer);
        
        return answer;
    }
    
    private void dfs(int count, boolean[] visited, int[] candidates, List<Integer> nums, List<List<Integer>> answer) {
        if (count == candidates.length) {
            answer.add(new ArrayList<>(nums));
            return;
        }
        
        for (int i=0; i<candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            nums.add(candidates[i]);
            dfs(count + 1, visited, candidates, nums, answer);
            nums.remove(nums.size() - 1);
            visited[i] = false;
        }
    }
}