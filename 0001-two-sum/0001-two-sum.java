class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> indexes = map.get(nums[i]);
                indexes.add(i);
                map.put(nums[i], indexes);
            } else {
                List<Integer> newIndexes = new ArrayList<>();
                newIndexes.add(i);
                map.put(nums[i], newIndexes);
            }
        }
        
        int[] answer = new int[2];
        for (int i=0; i<nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                answer[0] = i;
                for (int nextIndex : map.get(find)) {
                    if (i != nextIndex)  {
                        answer[1] = nextIndex;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}