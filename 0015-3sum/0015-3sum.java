class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> answer = new HashSet<>();
        for (int i=0; i<nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    List<Integer> nodes = new ArrayList<>();
                    nodes.add(nums[i]);
                    nodes.add(nums[left]);
                    nodes.add(nums[right]);
                    answer.add(nodes);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return new ArrayList<>(answer);
    }
}