class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m;
        for (int j=0; j<nums2.length; j++) {
            nums1[i++] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}