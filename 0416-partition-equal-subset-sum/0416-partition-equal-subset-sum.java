class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        
        if (total % 2 != 0) {
            return false;
        }
        
        int target = total / 2;
        Set<Integer> sums = new HashSet<>();
        for (int num : nums) {
            if (num == target) {
                return true;
            }
            
            Set<Integer> temp = new HashSet<>();
            temp.add(num);
            
            for (int sum : sums) {
                if (num + sum == target) {
                    return true;
                }
                temp.add(num + sum);
            }
            
            sums.addAll(temp);
        }
        
        return false;
    }
}