class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        int len = intervals.length;
        List<int[]> nodes = new ArrayList<>();
        
        while (i<len && start > intervals[i][1]) {
            nodes.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        while (i<len && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        nodes.add(new int[]{start, end});
        
        while (i<len) {
            nodes.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }
        
        int[][] answer = new int[nodes.size()][2];
        for (i=0; i<nodes.size(); i++) {
            answer[i][0] = nodes.get(i)[0];
            answer[i][1] = nodes.get(i)[1];
        }
        return answer;
    }
}