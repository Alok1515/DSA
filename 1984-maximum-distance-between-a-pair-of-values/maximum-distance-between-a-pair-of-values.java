class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer

        int result = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                i++;
            } else {
                result = Math.max(result, j - i);
                j++;
            }
        }

        return result;
    }
}