class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> nodes = new PriorityQueue<>((o1, o2) -> {
            return (o2[0] * o2[0] + o2[1] * o2[1]) - (o1[0] * o1[0] + o1[1] * o1[1]);
        });
        for (int[] point : points) {
            nodes.add(point);
            
            if (nodes.size() > k) {
                nodes.poll();
            }
        }
        
        int[][] answer = new int[k][2];
        int i = k - 1;
        while (!nodes.isEmpty()) {
            answer[i] = nodes.poll();
            i--;
        }
        
        return answer;
    }
}