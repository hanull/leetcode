class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> container = new HashSet<>();
        for (int num : nums) {
            if (container.contains(num)) {
                return true;
            } else {
                container.clear();
                container.add(num);
            }
        }
        
        return false;
    }
}