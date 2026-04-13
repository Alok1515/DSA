class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        // stop early if i goes beyond possible better distance
        for (int i = 0; i < n && result > Math.abs(i - start); i++) {
            if (nums[i] == target) {
                result = Math.min(result, Math.abs(i - start));
            }
        }

        return result;
    }
}