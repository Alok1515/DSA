class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        for(int i = 0; i < nums1.length; i++) {

            int l = 0, r = nums2.length-1;

            while(l <= r) {

                int mid = l + (r - l) / 2;

                if(nums2[mid] == nums1[i]) {
                    return nums1[i];
                } else if(nums2[mid] > nums1[i]) {
                    r = mid -1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return -1;
    }
}