class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0])  {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i=1; i<intervals.length; i++) {
            int[] prev = stack.peek();
            
            if (intervals[i][0] >= prev[0] && intervals[i][0] <= prev[1]) {
                stack.pop();
                stack.add(new int[]{prev[0], Math.max(prev[1], intervals[i][1])});
            } else {
                stack.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }
        
        int[][] answer = new int[stack.size()][2];
        int index = answer.length - 1;
        for (int i=index; i>=0; i--) {
            int[] temp = stack.pop();
            answer[i][0] = temp[0];
            answer[i][1] = temp[1];
        }
        return answer;
    }
}