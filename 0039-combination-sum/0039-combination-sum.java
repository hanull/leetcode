class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target, answer);
        return answer;
    }
    
    public void dfs(int index, int sum, List<Integer> pickNums, int[] candidates, int target, List<List<Integer>> answer) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            answer.add(new ArrayList<>(pickNums));
            return;
        }
        
        for (int i=index; i<candidates.length; i++) {
            pickNums.add(candidates[i]);
            sum += candidates[i];
            dfs(i, sum, pickNums, candidates, target, answer);
            pickNums.remove(pickNums.size()-1);
            sum -= candidates[i];
        }
    }
}