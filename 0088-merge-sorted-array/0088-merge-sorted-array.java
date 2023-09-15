class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {
            return;
        }
        if (m==0) {
            for (int i=0; i<nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num:nums2) {
            pq.add(num);
        }
        int i=0;
        while (i < m+n) {
            if (i >= m && nums1[i] == 0) {
                while (!pq.isEmpty()) {
                    nums1[i] = pq.poll();
                    i++;
                }
                break;
            }
            if (nums1[i] > pq.peek()) {
                int temp = nums1[i];
                nums1[i] = pq.poll();
                pq.add(temp);
            }
            i++;
        }
    }
}