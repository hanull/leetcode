class Solution {
    
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for (int i=0; i<mat.length; i++) {
            int soldierCount = findAllSoldier(mat[i]);
            pq.add(new int[]{soldierCount, i});
        }
        
        int[] answer = new int[k];
        int index = 0;
        while (k-- > 0) {
            answer[index++] = pq.poll()[1];
        }
        return answer;
    }
    
    private int findAllSoldier(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (arr[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}