class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();

        for(int num : nums1) {

            set.add(num);
        }

        int common = 0;

        for(int num : nums2) {
            if(set.contains(num)) {
                common = num;
                break;
            }
        }

        return (common > 0) ? common : -1;
    }
}